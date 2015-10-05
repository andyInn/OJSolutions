package com.cun.java.learning;

/**
 * 要想把字符串S1变成S2，可以经过若干次下列原子操作： 1.删除一个字符 2.增加一个字符 3.更改一个字符
 * 
 * 字符串S1和S2的编辑距离定义为从S1变成S2所需要原子操作的最少次数。
 * 解法跟上面的最长公共子序列十分相似，都是动态规划，把一个问题转换为若干个规模更小的子问题，并且都借助于一个二维矩阵来实现计算。
 * 约定：字符串S去掉最后一个字符T后为S'，T1和T2分别是S1和S2的最后一个字符。 则dist(S1,S2)是下列4个值的最小者：
 * 
 * 1.dist(S1',S2')--当T1==T2 2.1+dist(S1',S2)--当T1!=T2，并且删除S1的最后一个字符T1
 * 3.1+dist(S1,S2')--当T1!=T2，并且在S1后面增加一个字符T2
 * 4.1+dist(S1',S2')--当T1!=T2，并且把S1的最的一个字符T1改成T2
 * 
 * 
 * 把问题转换为二维矩阵： arr[i][j]表示S1.sub(0,i)和S2.sub(0,j)的编辑距离，则
 * arr[i][j]=min{1+arr[i][j-1], 1+arr[i-1][j], 1+arr[i-1][j-1](当S1[i]!=S2[j]),
 * arr[i-1][j-1](当S1[i]==S2[j])} 边界情况：arr[0][j]=j, arr[i][0]=i
 * 代码就不写了，跟最长公共子序列很相似。
 * 
 * 计算两个字条串的相似度除了Edit Distance，还有一种方法是计算Jaro Distance。具体怎么算读者可以搜一下。
 * 
 * @author Andy
 */
public class _最长系列_字符串编辑距离 {
	public static int getEditDist(String s1, String s2) {
		// 把问题转换为二维矩阵：opt[i][j]表示S1.sub(0,i)和S2.sub(0,j)的编辑距离
		int[][] opt = new int[s1.length()][s2.length()];

		for (int i = 0; i < s2.length(); i++) {
			opt[0][i] = i;
		}
		for (int i = 0; i < s1.length(); i++) {
			opt[i][0] = i;
		}
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					opt[i][j] = opt[i - 1][j - 1];
				} else {
					opt[i][j] = Math.min(1 + opt[i][j - 1],
							Math.min(1 + opt[i - 1][j], 1 + opt[i - 1][j - 1]));
				}
			}
		}
		return opt[s1.length() - 1][s2.length() - 1];
	}

	public static void main(String[] args) {
		String x = "a1b2c3";
		String y = "a1b1c4";
		System.out.println(getEditDist(x, y));
	}
}
