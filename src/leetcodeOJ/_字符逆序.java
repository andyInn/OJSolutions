package leetcodeOJ;

import java.util.Scanner;

public class _字符逆序 {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		String s=cin.nextLine();
		StringBuilder sb=new StringBuilder();
		for (int i = s.length()-1; i >=0; i--) {
			sb.append(s.charAt(i));
		}
		System.out.println(sb);
	}
}