package com.beijing.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class _最高分是多少 {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		int N = 0, M = 0, max = 0, left = 0, right = 0;
		int[] stu = new int[30001];
		while (cin.hasNextInt()) {
			N = cin.nextInt();
			M = cin.nextInt();
			if (N <= 0 || N > 30000 || M <= 0 || M >= 5000)
				continue;
			Arrays.fill(stu, 0);
			left = 0; right = 0;
			for (int i = 1; i <= N; i++) {
				stu[i] = cin.nextInt();
			}
			for (int i = 1; i <= M; i++) {
				if (cin.next().equals("Q")) {
					max = 0;
					left = cin.nextInt();
					right = cin.nextInt();
					if (left > right) {
						left = left ^ right;
						right = left ^ right;
						left = left ^ right;
					}
					for (int j = left; j <= right; j++) {
						max = max > stu[j] ? max : stu[j];
					}
					System.out.println(max);
				} else {
					stu[cin.nextInt()] = cin.nextInt();
				}
			}
		}
		cin.close();
	}
}