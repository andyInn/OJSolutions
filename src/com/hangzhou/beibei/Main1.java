package com.hangzhou.beibei;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(), c = cin.nextInt(), m = cin.nextInt(), count = 0;
		if (n >= c) {
			count = n / c;
			count += count / m;
		}
		System.out.println(count);
	}
}
