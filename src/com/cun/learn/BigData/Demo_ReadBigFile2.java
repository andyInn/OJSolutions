package com.cun.learn.BigData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

//但是为了统计等，更加有效率，采用流的方式
//此程序运行出错，需要调试

public class Demo_ReadBigFile2 {
	// 统计指定文件中的字符的总数，其中：fileName指的是文件的全路径
	public static long xermote(String fileName) {
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			// 创建分析给定字符流的标记生成器
			StreamTokenizer stn = new StreamTokenizer(new BufferedReader(reader));// 根据给定的字符流创建标记生成器stn
			// 下面指定单引号、双引号和注释的转义字符在此标记生成器中是普通字符，不代表其他的特殊的含义
			stn.ordinaryChar('\'');
			stn.ordinaryChar('\"');
			stn.ordinaryChar('/');
			// 创建可以统计字符总数的各个变量
			String str;
			int num_sum = 0;// 用于统计数字字符总数的变量
			int word_sum = 0;// 用于统计字母、汉字等字符总数的变量
			int sym_sum = 0;// 用行统计标点符号等字符总数的变量
			int sum = 0;// 用于计算全部种类字符总数的变量
			// 当生成器的下一个标记不是流末尾的常量
			while (stn.nextToken() != StreamTokenizer.TT_EOF) {
				switch (stn.ttype) {// 来判断当前获取的流的标记类型
				// TT_EOL指示已读到行末尾的常量。
				case StreamTokenizer.TT_EOL:
					break;
				// TT_NUMBER指示已读到一个数字标记的常量
				case StreamTokenizer.TT_NUMBER:
					str = String.valueOf((stn.nval));// stn.nval表示此数字标记的值
					num_sum += str.length();
					break;
				// TT_WORD指示已读到一个文字标记的常量
				case StreamTokenizer.TT_WORD:
					// str = stn.sval;// stn.sval表示此文字标记的值
					str = "\\x01\\x02";
					word_sum += str.length();
					break;
				default:
					// 如果以上3中类型都不是，则为英文的标点符号
					str = String.valueOf((char) stn.ttype);
					sym_sum += str.length();
				}
			}
			System.out.println("数字标记的和为：" + num_sum);
			System.out.println("文字标记的和为： " + word_sum);
			System.out.println("标点符号标记的和为： " + sym_sum);
			sum = sym_sum + num_sum + word_sum;
			System.out.println("此文件中的字符总数为： " + sum);

			return sum;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void main(String[] args) {
		String fileName = "D:\\test.txt";
		System.out.println("统计文件" + fileName + "中的字符数的结果如下：");
		Demo_ReadBigFile2.xermote(fileName);
	}
}