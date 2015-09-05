package leetcodeOJ;

public class _053MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int sum = nums[0], thisSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			thisSum += nums[i];
			thisSum = Math.max(thisSum, nums[i]);
			if (sum < thisSum)
				sum = thisSum;
		}
		return sum;
	}

	public static void main(String... strings) {
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
