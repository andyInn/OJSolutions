package com.google.codejampractise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BadHorse_s {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt(), count=0;
		sc.nextLine();
		while(T-- >0){
			int M=Integer.parseInt(sc.nextLine());
			String a="",b="";
			boolean isOk=true;
			Set<String> set1=new HashSet<String>();
			Set<String> set2=new HashSet<String>();
			while(M-- >0){
				a=sc.nextLine();
				String[] s=a.split(" ");
				a=s[0];
				b=s[1];
				if((set1.contains(a)&&set1.contains(b))
					||(set2.contains(a)&&set2.contains(b))){
					isOk=false;
				}else if(set1.contains(a)){
					set2.add(b);
				}else if(set2.contains(a)){
					set1.add(b);
				}else if(set1.contains(b)){
					set2.add(a);
				}else if(set2.contains(b)){
					set1.add(a);
				}else{
					set1.add(a);
					set2.add(b);
				}
			}//while
			if(isOk==true){
				System.out.println("Case #"+ ++count+": Yes");
			}else {
				System.out.println("Case #"+ ++count+": No");
			}
		}
	}
}
