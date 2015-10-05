package com.cun.java.learning;
/*给定字符串str1和str2，求str1的子串中含有str2所有字符的最小子串长度。
【举例】
str1="abcde”，str2="ac"。因为"abc"包含str2的所有字符，并且在满足这一条件的str1的所有子串中，”abc"是最短的，所以返回3。
str1="12345”，str2="344"。最小包含子串不存在，返回0。
*/
public class _求str1的子串中含有str2所有字符的最小子串长度 {
	/**
	 * 就是借款，还款问题
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int minLength(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() < str2.length()) {
			return 0;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[] map = new int[256];//表示哈希表
		for (int i = 0; i != chas2.length; i++) {
			map[chas2[i]]++;//记录str2中每个字符出现的次数，没出现过的为0
		}
		int left = 0;
		int right = 0;
		int match = chas2.length;
		int minLen = Integer.MAX_VALUE;
		while (right != chas1.length) {
			map[chas1[right]]--;//对str1每个字符，直接还款
			if (map[chas1[right]] >= 0) {//是有效还款
				match--;
			}
			if (match == 0) {//还完了
				while (map[chas1[left]] < 0) {//右边界定了，左边界需要右移，以确定最小的子串长度
					map[chas1[left++]]++;//将无效还款退还
				}
				minLen = Math.min(minLen, right - left + 1);//更新最小子串长度
				match++;//此处及下一行表示往右走一个位置，那么总需还款数要+1，1和0之间摇摆
				map[chas1[left++]]++;//以left+1位置为左边界开始新一轮还款逻辑
			}
			right++;//每次右边界右移一个位置
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		String str1 = "adabbca";
		String str2 = "acb";
		System.out.println(minLength(str1, str2));
	}
}
