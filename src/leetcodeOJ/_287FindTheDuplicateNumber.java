package leetcodeOJ;

public class _287FindTheDuplicateNumber {
	public static int findDuplicate(int[] nums) {
		if (nums == null || nums.length < 2)
			return -1;
		for (int i = 0, m = 0; i < nums.length; i++) {
			while (nums[i] != i + 1) {
				if (nums[nums[i] - 1] == nums[i])
					return nums[i];
				else {
					m = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = m;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 8, 4, 8, 5, 8, 6 };
		System.out.println(findDuplicate(nums));
	}
}