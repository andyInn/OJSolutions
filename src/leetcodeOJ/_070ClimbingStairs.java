package leetcodeOJ;

public class _070ClimbingStairs {
	public static int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int a = 1, b = 2;
		for (int i = 2; i < n; i++) {
			a += b;
			a ^= b;
			b = a ^ b;
			a ^= b;
		}
		return b;
	}

	public static void main(String... strings) {
		System.out.println(climbStairs(5));
	}
}
