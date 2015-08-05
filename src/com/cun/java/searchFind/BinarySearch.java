package com.cun.java.searchFind;

public class BinarySearch {
	private static int binarySearch(int[] arr, int low, int high, int target) {
	    int mid = 0;
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
	    return low;
	}
}
