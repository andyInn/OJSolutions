package com.beijing.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class _笔画 {
/*	经我的代码AC后判断，输入的是 1、边的个数 2、每条边的顶点编号 比如sample给的输入，
	就是这个图形总共有三条边，1 和2是第一条边的两个顶点，2和3是第二条边的两个顶点，
	1和3是第三条边的两个顶点 这里面没有坐标
	
	给大家点建议，此题考欧拉图相关内容，若一个图为欧拉图或半欧拉图都可以通过一笔画遍历。

	通过图（有向图或无向图）中的所有边且每一条边仅通过一次的通路称为欧拉通路，若此通路为回路则称为欧拉回路。

	具有欧拉回路的图称为欧拉图，具有欧拉通路而无欧拉回路的图称为半欧拉图。

	此题为无向图：

	无向图Ｇ是欧拉图当且仅当Ｇ是连通的且没有奇度顶点。

	无向图Ｇ是半欧拉图当且仅当Ｇ是连通的且恰有两个奇度顶点。
	
	楼上说的对，这题目说明是有问题的。这个OJ上很多题目都表示不清，但这个表述是错的。
	输入的第一个数字是边的数目 后面是每两个数字组成的边的信息。有几个节点就从边的信息里提取。 
	只有是连通图而且度为奇数的节点等于0或者2时才输出true。其他情况都是false。*/
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();//输入n条边
		int v1=0,v2=0,len=0,vStart=1,count=0;//count 为顶点度为奇数的个数
		List<Integer> vli=new ArrayList<Integer>();
		List<Edge> eli=new ArrayList<Edge>();
		while(n-- >0){
			v1=cin.nextInt();
			if(!vli.contains(v1))
				vli.add(v1);
			v2=cin.nextInt();
			if(!vli.contains(v2))
				vli.add(v2);
			
			Edge e=new Edge(v1,v2);
			eli.add(e);
		}
		
		len=vli.size();
		int[][] adjMatrix=new int[len+1][len+1];
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (Edge e : eli) {//建立邻接矩阵
			adjMatrix[e.v1][e.v2]=1;
			adjMatrix[e.v2][e.v1]=1;
			
			//统计每个顶点度数
			if(!map.containsKey(e.v1))
				map.put(e.v1, 1);
			else {
				map.put(e.v1, map.get(e.v1)+1);
			}
			if(!map.containsKey(e.v2))
				map.put(e.v2, 1);
			else {
				map.put(e.v2, map.get(e.v2)+1);
			}
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(vStart);
		while(!q.isEmpty()){//查看图是否连通, BFS
			vStart=q.poll();
			vli.remove(Integer.valueOf(vStart));
			for (int i = 1; i <= len; i++) {
				if(adjMatrix[vStart][i]==1){//存在边
					if(vli.indexOf(i)!=-1){//未访问过
						q.offer(i);
						vli.remove(Integer.valueOf(i));
					}
				}
			}//for
		}
		
		//print the result
		/*给大家点建议，此题考欧拉图相关内容，若一个图为欧拉图或半欧拉图都可以通过一笔画遍历。

		通过图（有向图或无向图）中的所有边且每一条边仅通过一次的通路称为欧拉通路，若此通路为回路则称为欧拉回路。
		具有欧拉回路的图称为欧拉图，具有欧拉通路而无欧拉回路的图称为半欧拉图。

		此题为无向图：

		无向图Ｇ是欧拉图当且仅当Ｇ是连通的且没有奇度顶点。
		无向图Ｇ是半欧拉图当且仅当Ｇ是连通的且恰有两个奇度顶点。*/
		if(vli.size()!=0){//此无向图不连通
			System.out.println("false");
			return;
		}else {//连通
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if((entry.getValue()&1)==1) count++;
			}
			if(count==0||count==2){//日:(连通)7 1 2 2 3 3 4 4 5 5 6 1 6 2 5
				System.out.println("true");
			}else {//目：（不连通）10 1 2 2 3 3 4 4 5 5 6 6 7 7 8 1 8 2 7 3 6
				System.out.println("false");
			}
		}
	}
}
class Edge{
	public int v1;
	public int v2;
	public Edge(){}
	public Edge(int v1,int v2){
		this.v1=v1;
		this.v2=v2;
	}
}