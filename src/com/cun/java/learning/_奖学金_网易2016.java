package com.cun.java.learning;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class _奖学金_网易2016 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		int avg = in.nextInt();
		int a = 0, b = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int pin = 0;// 平时总成绩
		for (int i = 0; i < n; i++) {
			a = in.nextInt();
			pin += a;
			b = in.nextInt();
			if (map.get(b) != null) {
				map.put(b, map.get(b) + r - a);
			} else {
				map.put(b, r - a);
			}
		}
		int sum = avg * n;// 要拿奖学金成绩
		int xu = sum - pin;// 需要的考试成绩
		Set<Integer> set = map.keySet();
		int res = 0;// 记录结果
		int index = 0;
		for (Integer e : set) {
			index = map.get(e);
			if (index * e <= xu) {
				res += index * e;
				xu -= index * e;
			} else {
				res += e * xu;
				break;
			}
		}
		System.out.println(res);
		in.close();
	}
}