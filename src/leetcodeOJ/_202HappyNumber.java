package leetcodeOJ;

import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
	public boolean isHappy(int n) {
		int sum = 0, digit = 0;
		boolean res = false;
		Set<Integer> set = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder(String.valueOf(n));
		while (true) {
			for (int i = 0; i < sb.length(); i++) {
				digit = sb.charAt(i) - 48;
				sum += digit * digit;
			}
			if (sum == 1) {
				res = true;
				break;
			}
			if (set.contains(sum))
				break;
			sb = new StringBuilder(String.valueOf(sum));
			set.add(sum);
			sum = 0;
		}// while
		return res;
	}

	public static void main(String[] args) {
		_202HappyNumber sl=new _202HappyNumber();
		System.out.println(sl.isHappy(2));
	}
}