package com.cun.java.learning;

import java.util.Arrays;

/**
 * 有一个机器按自然数序列的方式吐出球(1 号球,2 号球,3 号球,......)，
 * 你有一个袋子，袋子最多只能装下K个球，并且除袋子以外，你没有更多的空间。
 * 设计一种选择方式，使得当机器吐出第N号球的时候(N>K)，你袋子中的球数是K个，
 * 同时可以保证从1号球到N号球中的每一个，被选进袋子的概率都是K/N。
 * 举一个更具体的例子。有一个只能装下10个球的袋子，当吐出100个球时，袋子里有10个球，
 * 并且1~100号中的每一个球被选中的概率都是10/100。
 * 然后继续吐球，当吐出1000个球时，袋子里有10个球，并且1~1000号中的每一个球被选中的概率都是10/1000。
 * 继续吐球，当吐出i个球时，袋子里有10个球，并且1~i号中的每一个球被选中的概率都是10/i，
 * 即吐球的同时，已经吐出的球被选中的概率也动态地变化。
 * @author Andy
 *
 */
public class _腾讯面试_设计抽奖系统 {
	/**
	 * 就是抽奖问题，在用户登录系统的时候就确定其是否被抽中。
	 * 蓄水池问题
	 */
	//一个简单的随机函数，决定一个事情做还是不做
	public static int rand(int max) {
		return (int) (Math.random() * max) + 1;
	}

	public static int[] getKNumsRand(int k, int max) {
		if (max < 1 || k < 1)
			return null;
		int[] res = new int[Math.min(k, max)];
		for (int i = 0; i < res.length; i++) {
			res[i] = i + 1;// 前K个数直接进袋子
		}
		for (int i = k + 1; i < max + 1; i++) {
			if (rand(i) <= k) {// 决定第i个球进不进袋子
				res[rand(k) - 1] = i;// i随机替掉袋子中的一个
			}
		}
		return res;
	}
	
	public static void main(String ...strings){
		System.out.println(Arrays.toString(getKNumsRand(5, 100)));
	}
}
