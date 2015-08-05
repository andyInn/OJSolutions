package com.cun.java.searchFind;
/**
 * 动态规划求解
╔
 	问题描述：输入是一个大小为n的整型数组，要求输出数组的任何连续子数组中的最大值。
 	例如：输入的数组为array[10] = {31,-41,59,26,-53,58,97,-93,-23,84};
 	输出最大连续子数组和为array[2...6]：187
	设b[i]表示以a[i]结尾 的子数组的最大子段和，即：b[i]=max{sum(a[j~k])},其中0<=j<=i，j<=k<=i。
	因此对于数组a[0~n]的最大字段和为max{b[i]}，其中0<=i<n。
 
	在计算b[i]时，可以考虑以下三种情况：
	1，b[i] = b[i-1]+a[i]，当b[i-1]>0时，这时候的b[i]中包含a[i]。
	2，b[i] = a[i]，当b[i-1]<=0，这时候以a[i]重新作为b[i]的起点。
	3，b[i]不包含a[i]的情况，这种情况在计算b[i]之前已经计算处结果，保存在b[0~i-1]中。最后计算max{b[i]}时会考虑到。
	b[i] = max{ b[i-1]+a[i]，a[i]}。
	而数组a[0~n]则为max{b[i]}。在实现时，可以省略数组b[i]。
╝②
	动态规划求解的时间复杂度是O(n)。可以记录最大连续子数组和的起始和末尾位置。
 * @author Andy
 *
 */
public class Main_DP_demo{
	public static int maxSubsequenceSum(int A[]) {
		int ThisSum = 0, MaxSum = 0;
		for (int index = 0; index < A.length; index++) {
			ThisSum += A[index];
			if (ThisSum > MaxSum) MaxSum = ThisSum;
			else if (ThisSum < 0) ThisSum = 0;
		}
		return MaxSum;
	}
	
	public static void main(String[] args) throws Exception {
		int[] arr={1,1,1,0,-2,5,5,-3};
		System.out.println(maxSubsequenceSum(arr));
	}
}