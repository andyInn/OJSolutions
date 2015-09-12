package com.beijing.huawei;

import java.util.Scanner;

public class _扑克牌大小 {
	public static int getIndex(String str){
		return "345678910JQKA2jokerJOKER".indexOf(str);
	}
	
	public static boolean compare(String str1, String str2){
		return getIndex(str1) < getIndex(str2) ? true : false;
	}
	
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		String s=cin.nextLine();
		String[] ss=s.split("-"),left,right;
		if(ss[0].equals("joker JOKER")||ss[1].equals("joker JOKER"))
			System.out.println("joker JOKER");
		else if(ss[0].equals("JOKER joker")||ss[1].equals("JOKER joker"))
			System.out.println("JOKER joker");
		else{//no jokers
			left=ss[0].split(" ");
			right=ss[1].split(" ");
			if (left.length==4&&right.length!=4) {
				System.out.println(ss[0]);
			}else if (right.length==4&&left.length!=4) {
				System.out.println(ss[1]);
			}else if(left.length==4&&right.length==4){
				System.out.println(compare(left[0], right[0])?ss[1]:ss[0]);
			}else{//no 炸
				if(left.length!=right.length)
					System.out.println("ERROR");
				else {
					System.out.println(compare(left[0], right[0])?ss[1]:ss[0]);
				}
			}
		}
		cin.close();
	}
}
