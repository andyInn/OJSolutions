package com.beijing.huawei;

import java.util.Scanner;

public class _合法IP {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		String[] ss = cin.nextLine().split("\\.");
		for (String string : ss) {
			if (string.trim().length() > 3) {
				System.out.println("NO");
				return;
			}
			int a = Integer.parseInt(string);
			if (a < 0 || a > 255) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
