package com.huawei;

import java.util.Scanner;

public class _字符串最后一个单词的长度 {

	public static void main(String ...strings) {
		Scanner cin=new Scanner(System.in);
		String s=cin.nextLine();
		String[] ss=s.split(" ");
		if(ss.length==0)
			System.out.println(0);
		else
			System.out.println(ss[ss.length-1].length());
	}
}