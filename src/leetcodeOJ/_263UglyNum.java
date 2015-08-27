package leetcodeOJ;

public class _263UglyNum {
	public static boolean isUgly(int num) {
		if (num <= 0)
			return false;
		if (num <= 6)
			return true;
		boolean res = true;
		while ((num & 1) == 0) {
			num = num >> 1;
		}
		while ((num % 3) == 0) {
			num = num / 3;
		}
		while ((num % 5) == 0) {
			num = num / 5;
		}
		if (num != 1)
			res = false;
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(isUgly(100));;
	}
}
