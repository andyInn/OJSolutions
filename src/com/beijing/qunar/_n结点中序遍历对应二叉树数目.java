package com.beijing.qunar;
/**
 * （24分）
 * 给定一个n个结点的二叉树的中序遍历，输出有多少种可能的二叉树与之对应？
 * @author Andy
 *
 */
public class _n结点中序遍历对应二叉树数目 {
	public static int calBT(final String inOrder, int n) {
		if (n < 3)
			return n;
		int sum = 0;
		for (int i = 0; i < n; i++) {// i结点依次为根
			int l = calBT(inOrder.substring(0, i), i);
			int r = calBT(inOrder.substring(i + 1), n - i - 1);
			l = l == 0 ? 1 : l;
			r = r == 0 ? 1 : r;
			sum += l * r;
		}
		return sum;
	}
	
	public static void main(String ...strings){
		String inOrder="ABCD";
		System.out.println(calBT(inOrder, inOrder.length()));
	}
}