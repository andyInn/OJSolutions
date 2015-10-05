package leetcodeOJ;
import java.util.Arrays;

public class _283MoveZeroes {
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int left = 0, sum = 0;// left:0的左边界,sum:0的个数
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum++;
				for (int j = left + sum; j < nums.length && nums[j] != 0; j++) {
					nums[left++] = nums[j];
					i = j;
				}
			} else {
				left++;
			}
		}
		for (int i = left; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String... strings) {
		int[] nums = { 0, 1, 0, 3, 12, 2, 5, 4, 0 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}