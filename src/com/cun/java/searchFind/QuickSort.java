package com.cun.java.searchFind;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
	/**
	 * 此为递归排序
	 * 空间复杂度在最坏情况下为O(n),平均情况下为O(logn)，以2为底。
	 * 快排的时间复杂度为O(nlogn)，以2为底，不稳定。
	 * 快速排序是所有内部排序算法中平均性能最优的排序算法。
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(long[] arr,int low,int high) {
		if(low<high){
			int pos=partition(arr, low, high);
			quickSort(arr, low, pos-1);
			quickSort(arr, pos+1, high);
		}
	}//quickSort
	
	public static int partition(long[] arr, int low, int high) {
		long pivot = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= pivot)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] <= pivot)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivot;
		return low;
	}// partition
	
	/**
	 * 此为快排的非递归实现，用一个栈stack来模拟
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort2(long[] arr, int low, int high){
		Stack<Integer> s=new Stack<Integer>();
		if(low<high){
			int pivot=0;
			s.push(low);
			s.push(high);
			while (!s.empty()) {
				int right = s.pop();
				int left = s.pop();
				pivot = partition(arr, left, right);
				if (left < pivot - 1) {
					s.push(left);
					s.push(pivot - 1);
				}
				if (right > pivot + 1) {
					s.push(pivot + 1);
					s.push(right);
				}
			}//while
		}
	}//quickSort2
	
	public static void main(String[] args){
		long[] arr={4,2,6,7,9,5,1,3};
		//QuickSort.quickSort(arr,0,7);
		QuickSort.quickSort2(arr,0,7);
		System.out.println(Arrays.toString(arr));
	}
}
