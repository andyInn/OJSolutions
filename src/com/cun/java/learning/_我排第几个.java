package com.cun.java.learning;

import java.util.Scanner;
/*描述
现在有"abcdefghijkl”12个字符，将其所有的排列中按字典序排列，给出任意一种排列，说出这个排列在所有的排列中是第几小的？
 
输入
第一行有一个整数n（0<n<=10000）;
随后有n行，每行是一个排列；
输出
输出一个整数m，占一行，m表示排列是第几位；

样例输入
3
abcdefghijkl
hgebkflacdji
gfkedhjblcia

样例输出
1
302715242
260726926*/
public class _我排第几个 {
	public static final int MAX = 12;
	public static char[] a = new char[MAX];
	public static int[] fac = new int[MAX + 1];

	/**
	 * 计算a[k]位置有多少字符比a[k]大且前面没有出现过
	 * 因为某个位置k确定了以后，后面的字符全排列就是比当前ch放在k位置大的情况数
	 * 所以需要求得有多少字符比a[k]大，并且先求出ans的阶乘！
	 * @param k
	 * @param ch
	 * @return
	 */
	public static int largers(int k, char ch) {
		int i, res = 0;
		res = 'l' - ch;
		for (i = 0; i < k; i++)
			if (a[i] > ch)
				res--;
		return res;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(), sum;//有n组测试数据
		fac[1] = 1;
		for (int i = 2; i <= 12; i++)
			fac[i] = fac[i - 1] * i;
		while (n-- > 0) {
			a = cin.nextLine().toCharArray();
			sum = 0;//共有多少种排列
			for (int i = 0; i < 11; i++) {
				sum += (largers(i, a[i]) * fac[11 - i]);
			}
			//这个题我是采用计算给定字符串后面还有多少个，所以最后需要减一下
			System.out.println(fac[12] - sum);
		}
	}
}
