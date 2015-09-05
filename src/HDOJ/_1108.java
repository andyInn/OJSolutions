package HDOJ;

import java.util.Scanner;

public class _1108 {
	/**
	 * Greatest common divisor
	 * 最大公约数
	 * 这里a、b均为正整数，无所谓两者大小，若a>b，那么第二次循环就换过来了，嗯
	 * @return
	 */
	public static int gcd(int a, int b) {
		if (a == b)
			return a;
		int remainder = 1;
		while (remainder > 0) {
			remainder = b % a;
			b = a;
			a = remainder;
		}
		return b;
	}

	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		int a = 0, b = 0;
		while (cin.hasNextInt()) {
			a = cin.nextInt();
			b = cin.nextInt();
			System.out.println(a / gcd(a, b) * b);
		}
	}
}
