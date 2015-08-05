package com.cun.practice;
/**
 * 本文件实现了全排列的递归与非递归函数，注意区分
 * 有一定约束条件的全排列
        对数1，2，3，4，5要实现全排序。要求4必须在3的左边，其它的数位置随意。 
         思路：首先使用上面的2种方法之一实现全排列，然后对全排列进行筛选，筛选出4在3左边的排列。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllRange {
	
	/**
	 * 此函数判断是否需要交换数据继续递归。
	 * 例如str为123256，那么begin<=1, end>=3时，needSwap返回false，
	 * 这里避免了交换相同的字符'2'后，出现同样的排列数，包括剔除  经过递归之后  子串中的重复串。
	 * 就是说不交换相同的字符，然后继续进行循环，寻找别的可能的排列数
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean needSwap(char[] arr, int begin, int end){
		for (int i = begin; i < end; i++) {
			if (arr[i] == arr[end])
				return false;
		}// for
		return true;
	}

	/**
	 * 递归求解一个字符串str的全排列
	 * @param str
	 * @param start
	 * @param list
	 */
	public static void allRange(String str, int start, List<String> list){
		char[] arr=str.toCharArray();
		char ch=arr[0];
//		byte[] bt=str.getBytes();
		int end = arr.length - 1;
		if (start == end) {
			list.add(str);
			return;
		}
		for (int i = start; i <= end; i++) {
			if (needSwap(arr, start, i)) {
				ch = arr[start];
				arr[start] = arr[i];
				arr[i] = ch;

				allRange(new String(arr), start + 1, list);

				ch = arr[start];
				arr[start] = arr[i];
				arr[i] = ch;
			}
		}
	}//allRange
	
	/**
	 * 非递归求解全排列数
	 * rp:replacePoint, rm:replaceMin
	 * @param str
	 * @param start
	 * @param list
	 */
	public static void allRange2(String str, int start, List<String> list){
		char[] arr=str.toCharArray();
		Arrays.sort(arr);
		list.add(new String(arr));//加入第一个最小的排列数
		int end=arr.length - 1,rp = end, tmp = rp, rm = rp;
		while(rp!=0){
			tmp=rp;
			rp--;
			if(arr[rp]<arr[tmp]){
				//找与替换点交换的点
				rm=findReplace(arr, rp);
				//交换
				arr[rp] = (char) (arr[rp] ^ arr[rm]);
				arr[rm] = (char) (arr[rp] ^ arr[rm]);
				arr[rp] = (char) (arr[rp] ^ arr[rm]);
				//将替换后的所有的数字进行反转
				StringBuilder reverse=new StringBuilder();
				for(int i=0;i<=rp;i++)
					reverse.append(arr[i]);
				for(int i=arr.length-1;i>rp;i--)
					reverse.append(arr[i]);
				System.out.println(reverse);//输出
				arr=reverse.toString().toCharArray();//重置arr
				rp=end;//将替换点置最后一个点，开始下一轮循环
			}
		}
	}
	
	/**
	 * 找到替换点后面比替换数大但为后面数中最小的那个数
	 * @param arr
	 * @param replacePoint
	 * @return
	 */
	public static int findReplace(char[] arr, int replacePoint){
		int index=arr.length-1;
		for (int i = index; i >replacePoint ; i--) {
			if(arr[i]>arr[replacePoint]){
				index=i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args){
		String str="321";
		List<String> list=new ArrayList<String>();
		AllRange.allRange(str, 0, list);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
