package HDOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2025 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> li=new ArrayList<Integer>();
		int lenStr = 0,start;
		char maxCh,t;
		String target = "(max)";
		while(sc.hasNext()){
			StringBuilder sb = new StringBuilder();
			li.clear();
			String str1=sc.next();
			sb.append(str1);
			lenStr = sb.length();
			maxCh = sb.charAt(0);
			li.add(1);
			for (int i = 1; i < lenStr; i++) {
				t=sb.charAt(i);
				if(maxCh==t) li.add(i+1);
				if(maxCh<t){
					li.clear(); li.add(i+1); maxCh=t;
				}
			}//for
			start =0;
			for (Integer integer : li) {
				sb.insert(start==0?integer:(integer+start*target.length()), target);
				start++;
			}//for
			System.out.println(sb.toString());
		}
	}
}
