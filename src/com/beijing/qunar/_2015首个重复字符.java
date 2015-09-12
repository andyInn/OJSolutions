package com.beijing.qunar;

public class _2015首个重复字符 {
	public static char findFirstRepeat(String A, int n) {
		if (A == null || n == 0)
			return ' ';
		char ch = ' ';
		for (int i = 1; i < n; i++) {
			ch = A.charAt(i);
			if (A.substring(0, i).indexOf(ch) != -1)
				return ch;
		}
		return ' ';
	}
	public static void main(String ...strings){
		String A="kdbaaak";
		int n=A.length();
		System.out.println(findFirstRepeat(A, n));
	}
}
