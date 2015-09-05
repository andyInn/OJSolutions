package leetcodeOJ;

import java.util.Arrays;

public class _137SingleNumberII {
	/**
	 * 这里我们需要重新思考，计算机是怎么存储数字的。
	 * 考虑全部用二进制表示，如果我们把 第 i th 个位置上所有数字的和对3取余，
	 * 那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0).
	 * 因此取余的结果就是那个 “Single Number”.
	 * 一个直接的实现就是用大小为 32的数组来记录所有 位上的和。
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] count = new int[32];
		Arrays.fill(count, 0);
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) != 0) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}
	
	/**
	 * ones    代表第i th 位只出现一次的掩码变量
	 * twos   代表第i th 位只出现两次次的掩码变量
	 * threes   代表第i th 位只出现三次的掩码变量
	 * 当第 i th 位出现3次时，我们就 ones 和 twos 的第 i th 位设置为0. 最终的答案就是 ones。
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < nums.length; i++) {
			twos |= ones & nums[i];
			ones ^= nums[i];// 异或3次 和 异或 1次的结果是一样的
			// 对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}

	public static void main(String... strings) {
		int[] nums={10,9,100,9,10,10,9};
		System.out.println(singleNumber2(nums));
	}
}