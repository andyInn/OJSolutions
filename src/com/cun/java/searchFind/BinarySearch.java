package com.cun.java.searchFind;

public class BinarySearch {
	/**
	 * @param arr
	 * @param target
	 * @return 找到的元素下标
	 */
	private static int binarySearch(int[] arr, int target) {
		if (arr == null || arr.length == 0)
			return -1;
		int mid = 0, low = 0, high = arr.length - 1;
	    while (low <= high) {
	        mid = (low + high) >> 1;
	        if(arr[mid] == target){
	            return mid;
	        }
	        if(arr[mid] > target){
	            high = mid - 1;
	        }else {
	            low = mid + 1;
	        }
	    }
	    return -1;//not found
	}
}
