package leetcodeOJ;

import java.util.Stack;

public class _125ValidPalindrome {

	public static boolean isPalindrome(String s) {
		boolean res = true;
		if (s == null)
			return false;
		if (s.equals(""))
			return true;
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		s=s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
					|| (ch >= 48 && ch <= 57))
				stack.push(ch);
		}
		int len = stack.size(), half = len >> 1;
		while (half-- > 0) {
			stack2.push(stack.pop());
		}
		if ((len & 1) == 1) {
			stack.pop();
		}
		while (!stack.isEmpty()) {
			if (!stack.pop().equals(stack2.pop())) {
				res = false;
				break;
			}
		}
		return res;
	}
	public static void main(String[] args){
		String s="12325";
		System.out.println(isPalindrome(s));
	}
}
