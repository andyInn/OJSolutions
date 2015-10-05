package com.cun.java.learning;

import java.util.Arrays;

public class _最长公共子串LongestCommonSubString {
	public static void getLCSString(String s1, String s2) {
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int maxLen = str1.length;//最后结果以str1为准，其实两个都可以啦，这里便于分析选其一
		int maxLength = 0, maxNum = 0;// maxLength记录最大子串的长度值,maxNum记录最大长度子串的个数
		int[] maxIndex = new int[maxLen];// 记录最大子串们最后一个元素的下标值
		int[] nEql = new int[maxLen]; // 记录对角线上的相等值的个数

		for (int i = 0; i < str2.length; i++) {
			for (int j = str1.length - 1; j >= 0; j--) {//因为str1为准，所以内层循环要为str1的
				if (str2[i] == str1[j]) {
					if ((i == 0) || (j == 0))
						nEql[j] = 1;
					else//斜对角线即相同的部分子串，左上角到右下角
						nEql[j] = nEql[j - 1] + 1;
				} else {
					nEql[j] = 0;//因为只有一个数组，故不可省略这一步
				}

				if (nEql[j] > maxLength) { // 如果大于,那暂时只有一个是最长的更新两个结果数组
					Arrays.fill(maxIndex, 0);
					maxLength = nEql[j]; // 更新对角线元素的最大值，之后在遍历时用作提取子串的长度
					maxNum=1;//更新最大子串个数
					maxIndex[0] = j; // 更新对角线元素最大值的位置
				} else if (nEql[j] == maxLength) { // 多个最大相同长度的子串
					maxIndex[maxNum++] = j;
				}
			}
		}

		int index = 0;
		while (maxNum-- > 0) {
			System.out.println("第" + (++index) + "个公共子串:");
			System.out.println(s1.substring(maxIndex[index - 1] - maxLength + 1, maxIndex[index - 1] + 1));
		}
	}

	public static void main(String[] args) {
		String str1 = new String("123456abcd567");
		String str2 = new String("234dddabc45678");//234,abc,456,567
		getLCSString(str1, str2);
	}
}
