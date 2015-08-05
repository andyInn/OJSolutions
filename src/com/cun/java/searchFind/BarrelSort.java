package com.cun.java.searchFind;

/**
 * 用ASCII码排序，小写字母加倍，如a：97->194 大写字母对应到小写字母下一个数值，即A->195
 * 这样整个数组长度为52，a对应0位置，A对应1位置
 * @author Andy
 */
public class BarrelSort {
	public static void barrelSort(String text) {
		String[] t=text.split(",");
		int len = t.length;
		int[] temp = new int[len];
		// 桶排序处理
		int[] arr = new int[52];
		char ch;
		for (int i = 0; i < len; i++) {
			ch=t[i].charAt(0);
			if(Character.isLowerCase(ch)) temp[i]=2*ch;
			else temp[i]=2*(ch+32)+1;
		}
		//初始化arr[]
		for(int j=0;j<52;j++)arr[j]=0;
		//入桶
		for (int i = 0; i < len; i++) {
			arr[temp[i]-194]++;
		}
		//出桶
		int low=0,up=0,tt=0;
		for (int i = 0,j=0; i < 52; i++){
			j=arr[i];
			while(j>0){
				if (i % 2 == 0)
					low = (i + 194) >> 1;
				else {
					tt = (i + 194 - 1) >> 1;
					up = tt - 32;
				}
				System.out.print((char)(i%2==0?low:up));
				if(len>1)System.out.print(",");
				j--;len--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String text="R,B,B,b,W,W,B,R,B,w";
//		String text="B,b";
		barrelSort(text);
		// System.out.println("a:"+(byte)'a');
		// System.out.println("97:"+(char)97);
	}
}
