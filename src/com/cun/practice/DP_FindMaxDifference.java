package com.cun.practice;
/**
之前在电面的时候碰到一道题，要求找出一个互异数组中两个元素的最大差值。具体描述如下：
有一个整数数组d[0,...,n-1]，并且数组满足不存在相同的元素，要求找出
1) max{d[i] - d[j]} 且 i > j;(对应实际生活中的股票买卖，找出可能的最大收益)
2) max{d[i] - d[j]} 且 i < j;
思路有很多种，用动态规划最简单，时间复杂度都是O(n)，线性时间复杂度。
针对1)动规的模型如下：
1)设n>i>2,a(i)是以d[i]价格卖出的最大收益，那么最大收益就是d[i]的值减去d[0~i-1]中最小值，即最大收益
2)那么a(i+1)则是以d[i+1]价格卖出的最大收益，就是d[i+1]的值减去d[0~i]中最小值，而1)中已经求出了d[0~i-1]的最小值，只要把那个值与d[i]的值比较即可。
3)在所有可能的卖出点求出所有最大的收益，即为所求。
 * @author Andy
 *
 */
public class DP_FindMaxDifference {
	public static int findMaxDifference(int[] arr) {
		int maxDiff = arr[1] - arr[0], minPoint = arr[0];
		for (int i = 2; i < arr.length; i++) {
			if (arr[i - 1] < minPoint)
				minPoint = arr[i - 1];
			maxDiff = maxDiff > 
				(arr[i] - minPoint) ? maxDiff : arr[i] - minPoint;
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 5, 20, 22, 17, 3, 19 };
		System.out.println(findMaxDifference(arr));
	}
}
