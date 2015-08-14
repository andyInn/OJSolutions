package HDOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1176 {

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0) break;
			int[][] a=new int[100000][11];
			int maxTime=0,x=0,T=0;
			while(n-->0){
				x=sc.nextInt();
				T=sc.nextInt();
				if(maxTime<T) maxTime=T;
				a[T][x]++;
			}
			int[][] dp = new int[maxTime + 1][11];
			for (int i = 0; i < 11; i++) {
				dp[maxTime][i] = a[maxTime][i];
			}
			while(--maxTime >=0){
				for (int i = 0; i < 11; i++) {
					if(i==0){
						dp[maxTime][i]=max(dp[maxTime+1][i+1], dp[maxTime+1][i]) +a[maxTime][i];
					}else if(i==10){
						dp[maxTime][i]=max(dp[maxTime+1][i-1], dp[maxTime+1][i])+a[maxTime][i];
					}else{
						dp[maxTime][i]=max(max(dp[maxTime+1][i-1], dp[maxTime+1][i]), dp[maxTime+1][i+1])+a[maxTime][i];
					}
				}
			}//while
			System.out.println(dp[0][5]);
		}
	}
}
