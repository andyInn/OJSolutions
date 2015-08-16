package com.cun.java.graph;
/**
 * Dijkstra算法
1.定义概览

Dijkstra(迪杰斯特拉)算法是典型的单源最短路径算法，用于计算一个节点到其他所有节点的最短路径。
主要特点是以起始点为中心向外层层扩展，直到扩展到终点为止。
Dijkstra算法是很有代表性的最短路径算法，在很多专业课程中都作为基本内容有详细的介绍，如数据结构，图论，运筹学等等。
注意该算法要求图中不存在负权边。

问题描述：在无向图 G=(V,E) 中，假设每条边 E[i] 的长度为 w[i]，找到由顶点 V0 到其余各点的最短路径。（单源最短路径）

2.算法描述

1)算法思想：设G=(V,E)是一个带权有向图，把图中顶点集合V分成两组，第一组为已求出最短路径的顶点集合
（用S表示，初始时S中只有一个源点，以后每求得一条最短路径 , 就将加入到集合S中，直到全部顶点都加入到S中，算法就结束了），
第二组为其余未确定最短路径的顶点集合（用U表示），按最短路径长度的递增次序依次把第二组的顶点加入S中。
在加入的过程中，总保持从源点v到S中各顶点的最短路径长度不大于从源点v到U中任何顶点的最短路径长度。
此外，每个顶点对应一个距离，S中的顶点的距离就是从v到此顶点的最短路径长度，U中的顶点的距离，是从v到此顶点只包括S中的顶点为中间顶点的当前最短路径长度。

2)算法步骤：

a.初始时，S只包含源点，即S＝{v}，v的距离为0。U包含除v外的其他顶点，即:U={其余顶点}，若v与U中顶点u有边，则<u,v>正常有权值，若u不是v的出边邻接点，则<u,v>权值为∞。

b.从U中选取一个距离v最小的顶点k，把k，加入S中（该选定的距离就是v到k的最短路径长度）。

c.以k为新考虑的中间点，修改U中各顶点的距离；若从源点v到顶点u的距离（经过顶点k）比原来距离（不经过顶点k）短，则修改顶点u的距离值，修改后的距离值的顶点k的距离加上边上的权。

d.重复步骤b和c直到所有顶点都包含在S中。
 */
import java.util.Scanner;

public class Dijkstra {
	public static final int MAXINT = Integer.MAX_VALUE;
	public static final int MAXNUM = 21;//有效数据从1-20, 0处不记数据

	public static int dijkstra(int[][] A, int src, int dest) {
		int[] dist = new int[MAXNUM];// v0到其余每个点的距离
		int[] prev = new int[MAXNUM];// 除v0外其余每个点的前导点

		boolean[] S = new boolean[MAXNUM];
		int n = MAXNUM;
		for (int i = 1; i < n; ++i) {
			dist[i] = A[src][i];
			S[i] = false;
			if (dist[i] == MAXINT) {
				prev[i] = -1;
			} else {
				prev[i] = src;
			}
		}
		dist[src] = 0;
		S[src] = true;
		int u = src;// 找出当前未使用的点j的dist[j]最小值
		for (int i = 2; i < n; ++i) {
			int minDist = MAXINT;
			for (int j = 1; j < n; j++) {
				if ((!S[j]) && dist[j] < minDist) {
					u = j;// u保存当前邻接点中距离最小的点的号码
					minDist = dist[j];
				}
			}
			S[u] = true;//把点u加进来
			if (u == dest) {
				break;
			}
			for (int j = 1; j < n; j++) {// 更新未加入到S中的点的dist值
				if ((!S[j]) && A[u][j] < MAXINT) {
					if (dist[u] + A[u][j] < dist[j]) {// 在通过新加入的u点路径找到离v0点更短的路径
						dist[j] = dist[u] + A[u][j];// 更新dist
						prev[j] = u;// 记录前驱顶点
					}
				}
			}// for
		}// for
		return dist[u];
	}

	public static void main(String[] args) {
		int[][] A = new int[MAXNUM][MAXNUM];// 记录每两点间的距离值,MAXINT:无穷大,即两点间无边,1:相邻
		int X = 0, J = 0, N = 0, src = 0, dest = 0, res = 0, count = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			for (int i = 0; i < MAXNUM; i++) {
				for (int j = 0; j < MAXNUM; j++) {
					A[i][j] = MAXINT;// 初始化数组
				}
			}
			for (int i = 1; i <= 19; i++) {
				X = sc.nextInt();
				for (int k = 0; k < X; k++) {
					J = sc.nextInt();
					A[i][J] = 1;
					A[J][i] = 1;
				}
			}
			N = sc.nextInt();
			System.out.println("Test Set #" + ++count);
			for (int i = 0; i < N; i++) {
				src = sc.nextInt();
				dest = sc.nextInt();
				res = dijkstra(A, src, dest);
				System.out.println(src + " to " + dest + ": " + res);
			}
			System.out.println();
		}
	}// main
}
