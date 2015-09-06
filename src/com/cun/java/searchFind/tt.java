package com.cun.java.searchFind;

import java.util.Arrays;

public class tt {

	// 建立大顶堆
	public static void buildHeap(int[] A) {
		for (int i = ((A.length - 1) >> 1); i >= 0; i--) {
			adjustDown(A, i, A.length);
		}
	}

	public static void adjustDown(int[] A, int k, int len) {
		int pivot = A[k];
		for (int i = (k << 1); i < len; i = (i << 1)) {
			if (i + 1 < len && A[i] < A[i + 1])
				i++;
			if (pivot >= A[i])
				break;
			A[k] = A[i];
			k = i;
		}
		A[k] = pivot;
	}

	public static void heapSort(int[] A) {
		if (A == null || A.length == 0)
			return;
		buildHeap(A);
		for (int i = A.length - 1; i > 0; i--) {
			A[i] = A[i] ^ A[0];
			A[0] = A[i] ^ A[0];
			A[i] = A[i] ^ A[0];
			adjustDown(A, 0, i);
		}
	}
	
	public static void main(String ...strings){
		int[] A={1,2,5,3,4,88,0};
		heapSort(A);
		System.out.println(Arrays.toString(A));
	}
}
