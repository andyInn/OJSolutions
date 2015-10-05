package com.beijing.huawei;

import java.util.Scanner;

public class _密码验证合格程序 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			String s=cin.next();
			int A=0,a=0,n=0,others=0,flag=0;
			if(s.length()<9){
				System.out.println("NG");
				continue;
			}
			for (int i = 0; i < s.length(); i++) {
				if(Character.isDigit(s.charAt(i)))
					n++;
				else if(Character.isUpperCase(s.charAt(i)))
					A++;
				else if(Character.isLowerCase(s.charAt(i)))
					a++;
				else
					others++;
				if(i+6<s.length()){
					if(s.substring(i+3).contains(s.subSequence(i, i+3))){
						System.out.println("NG");
						flag=1;
						break;
					}
				}
			}//for
			if(flag==1)
				continue;
			if((n>0&&A>0&&a>0)||(others>0&&A>0&&a>0)
					||(n>0&&others>0&&a>0)||(n>0&&A>0&&others>0)){
				System.out.println("OK");
			}else{
				System.out.println("NG");
			}
		}
	}
}
