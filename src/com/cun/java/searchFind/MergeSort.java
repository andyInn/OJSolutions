package com.cun.java.searchFind;

public class MergeSort {
	public static void mergeSort(int a[], int left, int right) {
		if (left >= right) return;
		int mid = ((left + right) >> 1);
		mergeSort(a, left, mid);
		mergeSort(a, mid + 1, right);
		merge(a, left, mid, right);
	}
    
	public static void merge(int a[], int start, int mid, int end) {
		// 其实就是跟合并两个有序数组一样的步骤，稍有区别
		// 这里针对start到end闭区间的数据进行合并，并保存到a[]对应位置中
		int[] temp = new int[end - start + 1];
		int i = 0, left = start, right = mid + 1;// 因为start到mid是有序的，mid+1到end是有序的
		while (left <= mid && right <= end) // 因为start到mid是有序的，mid+1到end是有序的
			temp[i++] = a[left] < a[right] ? a[left++] : a[right++];
		while (left <= mid) temp[i++] = a[left++];
		while (right <= end) temp[i++] = a[right++];
		for (i = 0, left = start; left <= end; a[left++] = temp[i++]) ;// 因为Java没有指针，所以只能这样赋值
	}
    
    public static void main(String args[]) {
        int[] a=new int[]{35,123,5,95,56,242,43,44,65,24};
        mergeSort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
	        System.out.printf("%-5d",a[i]);
    }
}
