package com.cun.java.learning;

import java.util.Arrays;

public class _最长递增子序列LongestIncreasedSubSequence {
	/**
	 * 时间复杂度O(nlgn)
	 * @param arr 要查询的数组
	 * @return 找到的最长递增子序列结果数组
	 */
	public static int[] liss(int[] arr) {
		if (arr == null||arr.length < 2)
			return arr;
		
		// 这里的liss数组中liss[i]记录长度为i + 1
		// 递增子序列中 最大值最小 的子序列的最后一个元素（最大元素）在arr中的位置
		int[] lissArr = new int[arr.length];
		// 前驱元素数组，用于打印序列
		int[] preArr = new int[arr.length];
		//初始化
		lissArr[0] = 0;
		for (int i = 0; i < arr.length; ++i) {
			preArr[i] = i;
		}
		
		int nMaxLis = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>arr[lissArr[nMaxLis-1]]){//优先处理两种特殊情况
				preArr[i] = lissArr[nMaxLis-1];//更新前驱值
				lissArr[nMaxLis++] = i;//更新当前最长子序列的最大元素最小值
				continue;
			}else if(arr[i]<arr[lissArr[0]]){
				lissArr[0] = i;//更新当前最长子序列的最大元素最小值
				continue;
			}else {//arr[i]一定在当前最长递增子序列之中
				// 下面这块代码以二分查找确定当前元素应该在的最大子序列的长度值
				int right = nMaxLis-1, left = 0, mid = 0;
				while (left <= right) {// B-Search
					mid = (right + left) >> 1;
					if (arr[i] == arr[lissArr[mid]]) {
						break;
					}else if (arr[lissArr[mid]] < arr[i]) {
						left = mid + 1;
					} else {
						if(left==right){
							preArr[i] = lissArr[right-1];//更新前驱值
							lissArr[right] = i;//更新当前最长子序列的最大元素最小值
							break;
						}
						right = mid - 1;
					}
				}//while
			}
		}//for
		
		// 保存最长递增子序列
		int i = nMaxLis - 1;
		int[] res = new int[nMaxLis];
		int right = lissArr[nMaxLis - 1];
		while (preArr[right] != right) {
			res[i--] = arr[right];
			right = preArr[right];
		}
		res[i] = arr[right];

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 4, 8, 11, 17, 5, 20, 11 };//{ 1, -1, 0, 1, 2, 3, 6, -7 };
		System.out.println(Arrays.toString(liss(arr)));
	}
}
