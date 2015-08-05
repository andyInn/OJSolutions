package com.google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
//wrong answer
public class InfiniteHouseOfPancakes {
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
/**
Problem

At the Infinite House of Pancakes, there are only finitely many pancakes, but there are infinitely many diners who would be willing to eat them! When the restaurant opens for breakfast, among the infinitely many diners, exactly D have non-empty plates; the ith of these has Pi pancakes on his or her plate. Everyone else has an empty plate.

Normally, every minute, every diner with a non-empty plate will eat one pancake from his or her plate. However, some minutes may be special. In a special minute, the head server asks for the diners' attention, chooses a diner with a non-empty plate, and carefully lifts some number of pancakes off of that diner's plate and moves those pancakes onto one other diner's (empty or non-empty) plate. No diners eat during a special minute, because it would be rude.

You are the head server on duty this morning, and it is your job to decide which minutes, if any, will be special, and which pancakes will move where. That is, every minute, you can decide to either do nothing and let the diners eat, or declare a special minute and interrupt the diners to make a single movement of one or more pancakes, as described above.

Breakfast ends when there are no more pancakes left to eat. How quickly can you make that happen?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with D, the number of diners with non-empty plates, followed by another line with D space-separated integers representing the numbers of pancakes on those diners' plates.

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the smallest number of minutes needed to finish the breakfast.

Limits

1 ≤ T ≤ 100.
Small dataset

1 ≤ D ≤ 6.
1 ≤ Pi ≤ 9.
Large dataset

1 ≤ D ≤ 1000.
1 ≤ Pi ≤ 1000.
Sample
Input 
3
1
3
4
1 2 1 2
1
4
Output 
Case #1: 3
Case #2: 2
Case #3: 3

In Case #1, one diner starts with 3 pancakes and everyone else's plate is empty. One optimal strategy is:

Minute 1: Do nothing. The diner will eat one pancake.

Minute 2 (special): Interrupt and move one pancake from that diner's stack onto another diner's empty plate. (Remember that there are always infinitely many diners with empty plates available, no matter how many diners start off with pancakes.) No pancakes are eaten during an interruption.

Minute 3: Do nothing. Each of those two diners will eat one of the last two remaining pancakes.

In Case #2, it is optimal to let the diners eat for 2 minutes, with no interruptions, during which time they will finish all the pancakes.

In Case #3, one diner starts with 4 pancakes and everyone else's plate is empty. It is optimal to use the first minute as a special minute to move two pancakes from the diner's plate to another diner's empty plate, and then do nothing and let the diners eat for the second and third minutes.
 * @param args
 */
