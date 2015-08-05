package niuKe_exam;

public class Solution1 {
	/**
	 * [编程题] 最大的LeftMax与rightMax之差绝对值 给定一个长度为N的整型数组arr，可以划分成左右两个部分：
	 * 左部分arr[0..K]，右部分arr[K+1..arr.length-1]，K可以取值的范围是[0,arr.length-2]
	 * 求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？ 例如： [2,7,3,1,1]
	 * 当左部分为[2,7]，右部分为[3,1,1]时，左部分中的最大值减去右部分最大值的绝对值为4;
	 * 当左部分为[2,7,3]，右部分为[1,1]时，左部分中的最大值减去右部分最大值的绝对值为6; 最后返回的结果为6。
	 * 注意：如果数组的长度为N，请尽量做到时间复杂度O(N)，额外空间复杂度O(1)
	 */
	public int getMaxABSLeftAndRight(int[] arr) {
		/**
		 * 思路：
		 * 首先选出的左右两部分的那两个最大的数，其中一个肯定是整个数组中最大的数，
		 * 它可能被分在左边或右边，假设它在左边的话，那么只需要使右边那部分的最大的数最小就行， 这样就能得出答案。
		 * 而右边那部分一定包含数组最右边那个数（k的边界条件）， 假设刚才已找出的整个数组中最大的数下标为k，最右边那个数的下标为len-1，
		 * 假设在len-1前到k这段区间中的数都比vec[len-1]小，那么答案就是vec[k]-vec[len-1]，
		 * 若果这段区间内有比vec[len-1]大的，那么就把它归入左边部分，
		 * 这样子左边部分最大值还是vec[k]，而右边部分最大值还是vec[len-1]，所以这样子最终答案就是vec[k]-vec[len-1]。
		 * 同理，当vec[k]在右边部分时可以得出答案为vec[k]-vec[0]，所以最终答案就是 max( Max-vec[0],
		 * Max-vec[len-1] ) 了。
		 */
		int reL = 0, reR = 0, max = 0, i = 0;
		while (i < arr.length) {
			if (max < arr[i])
				max = arr[i];
			i++;
		}
		reL = Math.abs(arr[0] - max);
		reR = Math.abs(arr[arr.length - 1] - max);
		if (reL < reR)
			return reR;

		return reL;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 1, 1 };
		Solution1 s = new Solution1();
		System.out.println("s.getMaxABSLeftAndRight(arr)=" + s.getMaxABSLeftAndRight(arr));
	}
}
