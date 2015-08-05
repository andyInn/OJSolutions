package com.cun.learn.BigData;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * java读取大文件1G+
 * 
 * @author Andy
 * @date 20150311
 */
/**
 *  正常读取大文件，可能会想到用缓存
 *  这里对FileInputStream用BufferedInputStream进一步进行了缓存优化处理，处理大数据量很有用
 * @author Andy
 */

public class Demo_ReadBigFile {

	public static void readBigFile(String path) {
		BigInteger sum;
		try {
			File file = new File(path);
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件

			String line = "";
			sum = BigInteger.ZERO;
			while ((line = reader.readLine()) != null) {
				sum = sum.add(BigInteger.ONE);

			}

			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		readBigFile("D:\\test.txt");
	}

}