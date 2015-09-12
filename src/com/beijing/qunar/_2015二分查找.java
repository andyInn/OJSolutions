package com.beijing.qunar;

public class _2015二分查找 {
	public static int getPos(int[] A, int n, int val) {
		if (A == null || n == 0)
			return -1;
		int mid = 0, left = 0, right = n - 1;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (A[mid] == val) {
				while (mid >= 0 && A[mid] == val) {
					mid--;
				}
				return mid + 1;
			}
			if (A[mid] < val)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	
	public static void main(String ...strings){
		int[] A={1,2,3,5,6,7,9,9};
		int n=A.length;
		System.out.println(getPos(A, n, 9));
	}
}
