package leetcodeOJ;

public class _268MissingNumber {
	public static int missingNumber(int[] nums) {
		if (nums == null)
			return -1;
		int t = -1, len = nums.length, index = -1;
		for (int i = 0; i < len; i++) {
			while (nums[i] != i) {// not in right place, swap
				if (nums[i] == len) {
					index = i;
					break;
				}
				t = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = t;
			}
		}
		return index == -1 ? len : index;
	}

	public static void main(String... strings) {
		int[] nums = { 3, 0, 1, 2 };
		System.out.println(missingNumber(nums));
	}
}