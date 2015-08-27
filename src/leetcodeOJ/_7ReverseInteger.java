package leetcodeOJ;

public class _7ReverseInteger {
	public static int reverse(int x) {
		if (x >= 0 && x <= 9)
			return x;
		long res = 0;
		int low = 0;
		String s = String.valueOf(x);
		StringBuilder sb = new StringBuilder();
		if (s.charAt(0) == '-') {
			low = 1;
		}
		for (int i = s.length() - 1; i >= low; i--) {
			sb.append(s.charAt(i));
		}
		res = Long.parseLong(sb.toString());
		if (low == 1)
			res = 0l - res;
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return 0;
//			if (res > 0)
//				return Integer.MAX_VALUE;
//			else
//				return Integer.MIN_VALUE;
		}
		return (int) res;
	}
	
	public static int reverse2(int x) {
		return Integer.reverse(x);//越界时不时题目想要的结果
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
//		System.out.println((1l<<32)-1);
//		System.out.println((1l<<31)-1);
//		System.out.println(2147483647);
		System.out.println(Long.MAX_VALUE);
	}
}
