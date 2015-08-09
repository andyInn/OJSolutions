package HDOJ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class _2602_ZeroOnePack {
	public static int max(int a, int b){
		return a > b ? a : b;
	}
	
	public static void zeroOnePack(
		int[] res,int totalVolume, int volume, int value){
		for (int j = totalVolume; j >= volume; j--) {
			res[j] = max(res[j - volume] + value, res[j]);
		}
	}
	
	public static void completePack(
		int[] res,int totalVolume, int volume, int value){
		for (int j = volume; j <= totalVolume; j++) {
			res[j] = max(res[j - volume] + value, res[j]);
		}
	}
	
	public static void multiplePack(
		int[] res, int totalVolume, int volume, int value, int quatity) {
		if (volume * quatity >= totalVolume) {
			completePack(res, totalVolume, volume, value);
			return;
		}
		int k = 1;
		while (k < quatity) {
			zeroOnePack(res, totalVolume, k * volume, k * value);
			quatity -= k;
			k <<= 1;
		}
		zeroOnePack(res, totalVolume, volume * quatity, value * quatity);
	}
	
	/**
	 * 动态规划0-1背包问题初始解决方案
	 */
	public static void package_DP(){
		File f=new File("src/HDOJ/input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(f)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int T=sc.nextInt(), N=0, V=0;
		while (T-->0) {
			N=sc.nextInt();
			V=sc.nextInt();
			int[] arr1=new int[N+1],arr2=new int[N+1];
			int[][] res=new int[N+1][V+1];
			for (int i = 1; i < arr1.length; i++) {
				arr1[i]=sc.nextInt();
			}
			for (int i = 1; i < arr2.length; i++) {
				arr2[i]=sc.nextInt();
			}
			//start analyse
			Arrays.fill(res[0], 0);
			for(int i=1;i<=N;i++){
				for (int j = 0; j <= V; j++) {
					if (arr2[i] <= j) {
						res[i][j] = max(res[i - 1][j - arr2[i]] + arr1[i], res[i - 1][j]);
					} else {
						res[i][j] = 0;
					}
				}
			}//for
			System.out.println(res[N][V]);
		}
	}
	
	/**
	 * 此解决方案优化了保存结果的部分，空间复杂度减少了很多很多，但是逻辑还是一样的
	 */
	public static void package_DP2(){
		File f=new File("src/HDOJ/input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(f)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int T=sc.nextInt(), N=0, V=0;
		while (T-->0) {
			N=sc.nextInt();
			V=sc.nextInt();
			int[] a=new int[N+1],b=new int[N+1];
			int[] res=new int[V+1];
			for (int i = 1; i < a.length; i++) {
				a[i]=sc.nextInt();
			}
			for (int i = 1; i < b.length; i++) {
				b[i]=sc.nextInt();
			}
			//start analyse
			Arrays.fill(res, 0);
			for(int i=1;i<=N;i++){
				for (int j = V; j >= b[i]; j--) {
					res[j] = max(res[j - b[i]] + a[i], res[j]);
				}
			}//for
			System.out.println(res[V]);
		}
	}
	
	public static void main(String[] args){
//		package_DP();
		package_DP2();
	}//main
}
