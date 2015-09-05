package leetcodeOJ;

import java.util.Arrays;

public class _160SingleNumberIII {
	/**
	 * 扫两遍，第一遍全异或得值temp。取temp中最低位不为0的位，其余位置0。如temp = 6 = 0x110，则取0x010。
	 * 扫第二遍，所有 i & 0x010 == 0x010的数异或得一个结果，其余数异或得另一个结果。
	 * 原理是两个不同的数至少会有一个bit位不同，造成全异或的结果中至少一位为1.那么以该位做区分，即可得两数。
	 * @param nums
	 * @return
	 */
	public static int[] singleNumber(int[] nums) {
		int[] res = { 0, 0 };
		if (nums == null || nums.length == 0)
			return res;
		int xor = 0, count = 0, diff = 1;
		for (int i = 0; i < nums.length; i++) {
			xor ^= nums[i];
		}
		while ((xor & 1) == 0) {
			xor >>= 1;
			count++;
		}
		diff = 1 << count;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & diff) == diff)
				res[0] ^= nums[i];
			else
				res[1] ^= nums[i];
		}
		return res;
	}

	public static void main(String... strings) {
		int[] nums = { 10, 9, 100, 9, 10, 5, 6, 5, 6, 99 };
		System.out.println(Arrays.toString(singleNumber(nums)));
	}
}