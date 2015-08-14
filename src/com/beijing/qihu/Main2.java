package com.beijing.qihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=sc.nextInt();
		sc.nextLine();
		while(T-- >0){
			StringBuilder s=new StringBuilder(sc.nextLine());
			int len=s.length();
			Set<Character> set=new HashSet<Character>();
			List<Character> li=new ArrayList<Character>();
			for(int i=0;i<len;i++){
				char ch=s.charAt(i);
				if(!set.contains(ch)){
					set.add(ch);
					li.add(ch);
				}else{
					set.remove(ch);
					li.remove(li.indexOf(ch));
				}
			}//for
			System.out.println(li.get(0));
		}
	}//main
}