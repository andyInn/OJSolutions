package com.beijing.letv;
/**
 * 此问题核心思想就是根据数组的长度来快速找到这个最小值
 * 试想，如果数组长度为n，那么如果数组中没有[1-n]之间的数，那么最小正整数就是1，
 * 如果没有空位，那么最小正整数就是n+1，
 * 如果有一个空位，那么最小正整数就是这个空位值，
 * 如果有多个空位（无论连续与否），那么最小正整数就是最小的那个空位值，
 * @author Andy
 *
 */
public class _不在数组中的最小正整数 {
	public static int minNumber(int[] arr) {
		if (arr == null || arr.length == 0)
			return 1;
		int l = 0, r = arr.length;
		while (l < r) {
			if (arr[l] == l + 1)
				l++;// 放在了应该在的位置上
			else if (arr[l] < 1 || arr[l] > r) {// 非法数据
				arr[l] = arr[--r];
			} else {// 合法数据，但是不在正确位置上,swap(arr[arr[l]-1],arr[l])
				int t=arr[l] - 1;
				arr[t] = arr[t] ^ arr[l];
				arr[l] = arr[t] ^ arr[l];
				arr[t] = arr[t] ^ arr[l];
			}
		}// while
		return l + 1;
	}
	
	public static void main(String ...strings){
//		int[] arr={};
//		int[] arr={1,3,4};
		int[] arr={2,3};
		System.out.println(minNumber(arr));
	}
}
