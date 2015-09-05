package HDOJ;

import java.util.Scanner;

public class _1019 {
	public static long gcd(long a, long b) {
		if (a == b)
			return a;
		long remainder = 1;
		while (remainder > 0) {
			remainder = b % a;
			b = a;
			a = remainder;
		}
		return b;
	}

	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		int T = cin.nextInt(), N = 0;
		long res = 0, a = 0;
		while (T-- > 0) {
			N = cin.nextInt();
			res = cin.nextInt();
			for (int i = 0; i < N - 1; i++) {
				a = cin.nextInt();
				res = a / gcd(a, res) * res;
			}
			System.out.println(res);
		}
	}
}
