package com.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
//small-correct,large-regected
public class StandingOvation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb=new StringBuilder();
		while(sc.hasNext()){
			int T=sc.nextInt();
			for (int i = 0; i < T; i++) {
				if(i==0) sb.append(sc.nextLine());//读取T后面的回车\n
				int Smax=0,ySum=0,thisY=0;
				sb.delete(0, sb.length());
				sb.append(sc.nextLine());
				Smax=(int)sb.charAt(0);
				sb.delete(0, 2);
				Smax=(int)(sb.charAt(0)-'0');
				//进入case
				for (int j = 1; j < sb.length(); j++) {
					thisY=0;
					if(Smax<j) thisY+=(j-Smax); 
					Smax+=(thisY+(int)(sb.charAt(j)-'0'));
					ySum+=thisY;
				}//for
				System.out.printf("Case #%d: %d\n", i+1, ySum);
			}
		}
	}
}