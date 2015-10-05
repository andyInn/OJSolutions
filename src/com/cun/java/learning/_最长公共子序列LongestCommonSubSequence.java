package com.cun.java.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _最长公共子序列LongestCommonSubSequence {
	public static List<Character> getLCSSequence(String x,String y){
        int len1 = x.length();
        int len2 = y.length(); // 具体大小可自行设置
 
        // 构造二维数组记录子问题x[i]和y[i]的LCS的长度
        int[][] opt = new int[len1 + 1][len2 + 1];
        List<Character> res=new ArrayList<Character>();
 
        // 从后向前，动态规划计算所有子问题,也可从前到后
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))// 状态转移方程，现在的情况是左上角元素等于右下角元素值加1
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else// 状态转移方程，因为是子序列，故字母可以不挨着
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }
 
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (x.charAt(i) == y.charAt(j)) {
            	res.add(x.charAt(i));
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        return res;
	}
	
	public static void main(String[] args) {
        // 随机生成字符串
        // String x = GetRandomStrings(substringLength1);
        // String y = GetRandomStrings(substringLength2);
        String x = "a1b2c3";
        String y = "1a1wbz2c123a1b2c123";
        List<Character> res=getLCSSequence(x, y);
        for (Character ch : res) {
			System.out.print(ch);
		}
    }
 
    // 取得定长随机字符串
    public static String GetRandomStrings(int length) {
        StringBuffer buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }
}