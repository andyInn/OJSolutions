package com.google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class InfiniteHouseOfPancakes_small {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb=new StringBuilder();
		Consumer[] a=new Consumer[10];
		int[] cakes = new int[7];
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int D = sc.nextInt();
			sb.append(sc.nextLine());// 读取D后面的回车\n
			int pMax = 0, pNum = 0, j=0;
			long p1=0l,p2=0l,moves=0l, timeMax = 0l,temp=0l;
			sb.delete(0, sb.length());
			sb.append(sc.nextLine());
			Arrays.fill(cakes, 0);
			StreamTokenizer st=new StreamTokenizer(new BufferedReader(new StringReader(sb.toString())));
			while(st.nextToken()!=StreamTokenizer.TT_EOF){
				if(st.ttype==StreamTokenizer.TT_NUMBER) {
					cakes[j]=(int) st.nval;
					pMax = pMax<cakes[j]?cakes[j]:pMax;
					j++;
				}
			}
			a[0]=new Consumer(0,0);
			a[1]=new Consumer(1,0);
			a[2]=new Consumer(2,0);
			a[3]=new Consumer(3,0);
			/*a[4]=new Consumer(2,1);
			a[5]=new Consumer(2,1);
			a[6]=new Consumer(2,1);
			a[7]=new Consumer(2,1);
			a[8]=new Consumer(2,1);
			a[9]=new Consumer(2,1);*/
			if(4 <= pMax){
				for (int k = 4; k <= pMax; k++) {
					pNum=(k>>1);
					if(k%2==0) a[k]=new Consumer(a[pNum].time,1+(a[pNum].moves<<1));
					else a[k]=new Consumer((p1=a[pNum].time)>(p2=a[pNum+1].time)?p1:p2, 1+a[pNum].moves+a[pNum+1].moves);
				}
			}//if
			for (int k = 0; k < D; k++) {
				moves+=a[cakes[k]].moves;
				timeMax=timeMax<(temp=a[cakes[k]].time)?temp:timeMax;
			}
			System.out.printf("Case #%d: %s\n", i + 1, Long.toString(moves+timeMax>pMax?pMax:moves+timeMax));
		}
	}
	public static class Consumer{
		long time;
		long moves;
		public Consumer() {}
		public Consumer(long time, long moves) {
			this.time=time;
			this.moves=moves;
		}
	}
}