package com.cun.java.learning;

import java.util.ArrayList;
import java.lang.Object;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Test1 {
	public static void main(String[] args) {
		Object o=new Object();
		System.out.println(o.toString());
		Scanner cin=new Scanner(System.in);
		String line=cin.nextLine();
		if(line.length()==0||line.equals(""))
			System.out.println("当前为空行");
//		int a = 2;
//		String b = "3";
//		System.out.println(2 + "3");
//		System.out.println(a + b);
//		System.out.println(a+=b);
/*		int[] A=new int[10];
		int[][] A2=new int[10][5];
		List<Integer> list=new ArrayList<Integer>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		System.out.println(A2.length);
		System.out.println(A2[1].length);*/
//		System.out.println(A[5]);
//		System.out.println(A2[5][6]);
//		System.out.println(list.size());
//		System.out.println(map.size());
	}
}