package com.beijing.qunar;

import java.util.ArrayList;
import java.util.List;

public class _2015寻找Coder{
	public static String[] findCoder(String[] A, int n) {
		List<String> list = new ArrayList<String>();
		if (A == null || n == 0)
			return new String[] {};
		for (int i = 0; i < n; i++) {
			if (A[i].toLowerCase().indexOf("coder") != -1)
				list.add(A[i]);
		}
		String[] strs = new String[list.size()];
		return list.toArray(strs);
	}
	
	public static void main(String ...strings){
		String[] A = new String[]{"i am a coder","Coder Coder","Code"};
		int n=A.length;
		String[] res=findCoder(A, n);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
}