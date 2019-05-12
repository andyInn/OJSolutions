package leetcodeOJ;

public class _007ReverseInteger_2 {
	public static int reverse(int x) {
		int sign = 1, result = 0;
		if(x<0){
			sign = -1;
			x *= -1;
		}
		while(x>0){
			//to avoid overflow
			if (Integer.MAX_VALUE / 10 < result) return 0;
			result*=10;
			if (Integer.MAX_VALUE - x%10 < result) return 0;
			result+=x%10;
			x/=10;
		}
		return result *= sign;
	}
	
	public static int reverse2(int x) {
		return Integer.reverse(x);//越界时不时题目想要的结果
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
//		System.out.println((1l<<32)-1);
//		System.out.println((1l<<31)-1);
//		System.out.println(2147483647);
		System.out.println(Long.MAX_VALUE);
	}
}
