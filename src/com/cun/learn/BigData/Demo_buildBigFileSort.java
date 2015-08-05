package com.cun.learn.BigData;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 外部排序 指的是大文件的排序，即待排序的记录存储在外存储器上，待排序的文件无法一次装入内存，
 * 需要在内存和外部存储器之间进行多次数据交换，以达到排序整个文件的目的。选自百度百科。
 * 此程序可以正确执行
 * @author Andy
 */

public class Demo_buildBigFileSort {

	public static void main(String[] args) throws IOException {
		String strSource = "D:/TEMP/quickSort/test.txt";
		// 第一步： 首先我们先来创建一个大号的文件。
		File fileSource = new File(strSource);
		Demo_buildBigFileSort.buildBigFile(strSource);
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader fr = new BufferedReader(inputStreamReader);// 源数据文件读取。

		final int SIZE = 10000;// 这里是定义我们将源文件中所有数据以10000条记录作为单位进行分割，即分割后每个文件中包含10000条记录。
		int[] linesSplit = new int[SIZE];// 临时存放分割时的记录
		List<String> fileNames = new ArrayList<String>();// 保存所有分割文件的名称
		int index = 0;
		while (true) {
			String lineRead = fr.readLine();// 从原文件中读取一条记录
			if (lineRead == null) {// 如果读取完毕后，进行一次排序并保存
				fileNames.add(sortAndSave(linesSplit, index));
				break;
			}
			linesSplit[index] = Integer.valueOf(lineRead);
			index++;
			if (index == SIZE) {// 当nums里面读的数字到达长度边界时，排序，存储
				fileNames.add(sortAndSave(linesSplit, index));// sortAndSave是将nums中前index条记录先快速排序，然后存入文件，最好将文件名返回。
				index = 0;// 重置index
			}
		}
		fr.close();
		mergeSort(fileNames);// 将所有fileNames的文件进行合并
	}

	// 第一步： 首先我们先来创建一个大号的文件。
	public static void buildBigFile(String strSource) {
		File file = new File(strSource);
		int numCount = 100000;
		Random r = new Random();
		if (file.exists())
			file.delete();

		try {
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < numCount; i++) {
				fw.write(r.nextInt() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// sortAndSave是将linesSplit中前index条记录先快速排序，然后存入文件，最好将文件名返回
	public static String sortAndSave(int[] linesSplit, int size) throws IOException {
		QuickSort.quickSortIni(linesSplit, 0, size - 1);
		String fileName = "D:/TEMP/quickSort/sort/sort" + System.nanoTime() + ".txt";
		File rf = new File(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(rf));
		for (int i = 0; i < linesSplit.length; i++)
			bw.write(linesSplit[i] + "\n");
		bw.close();
		return fileName;
	}

	public static void mergeSort(List<String> fileNames) throws IOException {
		List<String> tempFileNames = new ArrayList<String>();
		for (int i = 0; i < fileNames.size(); i++) {
			//这里for就是做了这样一个操作：每次将两个有序List合并，并保证结果有序。
			//在数组里面这样做更简单，这里isFirst，firstNext两个变量保证第一次循环和以后两个List哪个读取新数据的正确执行。
			String resultFileName = "D:/TEMP/quickSort/result/result" + System.nanoTime() + ".txt";
			File resultFile = new File(resultFileName);
			tempFileNames.add(resultFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));

			File file1 = new File(fileNames.get(i++));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			if (i < fileNames.size()) {//保证i不会越界,如果还有文件未读到，继续if块
				File file2 = new File(fileNames.get(i));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				int num1 = 0;
				int num2 = 0;
				boolean isFirst = true;
				boolean firstNext = true;
				String numVal1 = null, numVal2 = null;
				while (true) {//将两个有序List合并，并保证结果有序。
					if (isFirst) {
						numVal1 = br1.readLine();
						numVal2 = br2.readLine();
						num1 = Integer.valueOf(numVal1);
						num2 = Integer.valueOf(numVal2);
						isFirst = false;
					} else if (firstNext)
						numVal1 = br1.readLine();
					else
						numVal2 = br2.readLine();
					if (numVal1 != null && numVal2 != null) {
						if (firstNext) {
							num1 = Integer.valueOf(numVal1);
						} else {
							num2 = Integer.valueOf(numVal2);
						}
						if (num1 < num2) {
							bw.write(num1 + "\n");
							firstNext = true;
						} else {
							bw.write(num2 + "\n");
							firstNext = false;
						}
					} else {
						if (numVal1 != null)
							bw.write(numVal1 + "\n");
						if (numVal2 != null)
							bw.write(numVal2 + "\n");
						break;
					}
				}// while
				
				while (true) {
					//将剩余的有序数据追加到结果文件中
					numVal2 = br2.readLine();
					if (numVal2 != null)
						bw.write(numVal2 + "\n");
					else
						break;
				}// while
				br2.close();
				file2.delete();
			}//if (i < fileNames.size())
			
			while (true) {//如果只剩最后一个或只有这一个文件，那么将剩余的有序数据追加到结果文件中去。
				String numVal1 = br1.readLine();
				if (numVal1 != null) {
					bw.write(numVal1 + "\n");
				} else
					break;
			}//while
			br1.close();
			file1.delete();
			bw.close();
		}//for (int i = 0; i < fileNames.size(); i++)
		int size = tempFileNames.size();
		if (size > 1) {//递归地将结果文件合并
			mergeSort(tempFileNames);
		} else if (size == 1) {//递归跳出条件
			File file = new File(tempFileNames.get(0));
			file.renameTo(new File("D:/TEMP/quickSort/result.txt"));
		}
	}//mergeSort
}

// 快速排序
class QuickSort {

	public int[] data;

	public QuickSort() {
	}

	// 这里本来可以用构造函数解决，非要写成静态函数去调quickSort
	public static void quickSortIni(int data[], int low, int high) {
		QuickSort qs = new QuickSort();
		qs.data = data;
		qs.quickSort(low, high);
	}

	// Step1,递归地进行快排
	private void quickSort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			quickSort(low, result - 1);
			quickSort(result + 1, hight);
		}
	}

	// Step2
	private int partition(int sortArray[], int low, int hight) {
		int key = sortArray[low];
		while (low < hight) {
			while (low < hight && sortArray[hight] >= key)
				hight--;
			sortArray[low] = sortArray[hight];
			while (low < hight && sortArray[low] <= key)
				low++;
			sortArray[hight] = sortArray[low];
		}
		sortArray[low] = key;
		return low;
	}

	// 打印当前数组内容
	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}