package com.beijing.huawei;

import java.util.Scanner;

public class _多线程 {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("ABCD");
		}
		System.out.println(sb);
	}
}