package com.beijing.qihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] a = new int[n+1][n+1];
			int aa = 0, bb = 0;
			for (int i = 0; i < m; i++) {
				aa = sc.nextInt();
				bb = sc.nextInt();
				a[aa][bb] = 1;
			}
			
			//start
			int num=0;
			List<Integer> res=new ArrayList<Integer>();
			boolean isOk=true;
			if(m>=n-1){
				for (int i = 1; i <= n; i++) {
					a[i][i]=1;
					isOk=true;
					for (int j = 1; j <= n; j++) {//判断别人是否认识自己
						if(a[j][i]==0){
							isOk=false;
							break;
						}
					}//for
					if(isOk==true){
						for (int j = 1; j <= n; j++) {//判断自己是否认识别人
							if (a[i][j] == 1 && i != j) {
								isOk=false;
								break;
							}
						}//for
					}
					if(isOk==true){
						num++;
						res.add(i);
					}
				}//for
			}
			if(res.size()==0||num==0){
				System.out.println(0+"\n");
			}else{
				System.out.println(num);
				for (int i = 0; i < res.size(); i++) {
					if(i==0){
						System.out.print(res.get(i));
					}else{
						System.out.print(" "+res.get(i));
					}
				}
			}
		}// while
	}// main
}
