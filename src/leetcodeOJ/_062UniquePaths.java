package leetcodeOJ;

import java.util.Arrays;

public class _062UniquePaths {
	public static int uniquePaths(int m, int n) {
		if(m==1||n==1)
			return 1;
		int[] arr=new int[n];
		Arrays.fill(arr, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[j]+=arr[j-1];
			}
		}
		return arr[n-1];
	}

	public static void main(String... strings) {
		System.out.println(uniquePaths(2, 2));
	}
}
