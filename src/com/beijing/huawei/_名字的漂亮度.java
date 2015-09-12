package com.beijing.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class _名字的漂亮度 {
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		String s = "";
		int N = cin.nextInt(),beauty=0,count=0;
		while (N-- > 0) {
			beauty = 0;
			count = 26;
			s = cin.next().toLowerCase();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i)))
					map.put(s.charAt(i), 1);
				else
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
			List<Map.Entry<Character, Integer>> list=new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
				public int compare(Map.Entry<Character, Integer> o1,Map.Entry<Character, Integer> o2){
					return o2.getValue().compareTo(o1.getValue());//倒序
				}
			});
			for (Entry<Character, Integer> entry : list) {
					beauty += entry.getValue() * count--;
			}
			System.out.println(beauty);
		}
	}
}
