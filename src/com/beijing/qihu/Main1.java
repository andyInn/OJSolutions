package com.beijing.qihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * 挑选镇长
360员工桂最近申请了一个长假，一个人背着包出去自助游了。
　　路上，他经过了一个小镇，发现小镇的人们都围在一棵树下争吵。桂上前询问情况，得知小镇的人们正缺一个镇长，他们希望能选一个知名又公正的镇长，即，大家希望能选出一个人，所有人都认识他，但同时他不认识镇上除自己以外的其他人（在此，我们默认每个人自己认识自己）。可是小镇里的人太多了，一下子大家谁也说服不了谁。
　　“这简单啊。”桂表示。于是他一下子统计出来了镇上人们相互之间的认识关系，并且一下子找到了合适的镇长人选。
　　现在你手上也拿到了这样一份认识关系的清单。其中上面给出的认识关系是单向的，即，A认识B与B认识A是相互独立的，只给出A认识B就不能认为B认识A，例如，我认识你，你不一定认识我。而且，这里的认识关系也不具有传递性，即，A认识B，B认识C，但这不代表A认识C。同时，为了方便处理，这份清单中，镇上的N个人依次编号为1到N。你能否像桂一样快速找到合适的镇长人选呢？ 
输入描述:
首先一个正整数T（T≤20），表示数据组数。
之后每组数据的第一行有2个整数n  和m  (1≤n≤105 ,0≤m≤3×105 )，依次表示镇上的人数和相互之间的认识关系数。
之后m行，第 i 行每行两个数Ai和Bi   (1≤Ai ,Bi ≤n  )，表示Ai认识Bi。（保证没有重复的认识关系，但可能存在自己认识自己的认识关系）
保证所有数据中80%的数据满足n≤1000,m≤10000


输出描述:
一共2T 行，每组数据对应2行。
第一行，一个整数，表示你所找出来的合适的镇长人选人数num i   。
第二行，num i 个整数，每两个数中间用空格隔开，表示你所选的合适的镇长的编号。
特别的，如果并没有找到合适的镇长，第一行输出一个数0，第二行留空即可（参见样例）。

输入例子:
3
2 0
3 2
1 2
3 2
4 5
1 1
2 1
3 1
4 1
3 3

输出例子:
0

1
2
1
1*/
public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n+1];
			int aa = 0, bb = 0, i = 0;
			for (i = 0; i < m; i++) {
				aa = sc.nextInt();
				bb = sc.nextInt();
				if(aa!=bb){
					a[bb] += 1;
					a[aa] -= 1;
				}
			}
			i = 0;
			if(m>=n-1){//关系数不够n-1就不用计算了
				for (i = 1; i <= n; i++) {
					if(a[i]==n-1)
						break;
				}//for
			}//if
			if (i > 0 && i <= n) {
				System.out.println(1+"\n"+i);
			}else {
				System.out.println(0+"\n");
			}
		}// while
	}// main
}