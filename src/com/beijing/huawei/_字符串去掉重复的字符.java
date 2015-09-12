package com.beijing.huawei;

import java.util.Scanner;

public class _字符串去掉重复的字符 {
	
	public static String removeDuplicates(String s){
		if(s==null)
			return "";
		if(s.length()<2)
			return s;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(sb.indexOf(String.valueOf(s.charAt(i)))==-1)
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String ...strings){
//		Scanner cin=new Scanner(System.in);
//		String s=cin.next();
		System.out.println(removeDuplicates("111235223568"));
	}
}
