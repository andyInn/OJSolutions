package com.beijing.jd;

import java.util.Scanner;

public class _2016_2年终奖 {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		final int LEN = 6;
		int[] arr = new int[LEN];
		int n = 0;
		while (cin.hasNextInt()) {
			for (int i = 0; i < LEN; i++) {// 1st line init
				arr[i] = cin.nextInt();
			}
			for (int i = 0; i < LEN - 1; i++) {// below 5 lines
				arr[0] += cin.nextInt();// 1st number
				for (int j = 1; j < LEN; j++) {// LEN-1 numbers
					n = cin.nextInt();
					arr[j] = Math.max(arr[j], arr[j - 1]) + n;
				}
			}
			System.out.println(arr[LEN - 1]);
		}
	}
}
