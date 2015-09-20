package com.cun.java.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Test1 {
	public static void main(String[] args) {
		int[] A=new int[10];
		int[][] A2=new int[10][5];
		List<Integer> list=new ArrayList<Integer>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		System.out.println(A2.length);
		System.out.println(A2[1].length);
//		System.out.println(A[5]);
//		System.out.println(A2[5][6]);
//		System.out.println(list.size());
//		System.out.println(map.size());
	}
}