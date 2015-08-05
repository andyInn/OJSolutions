package HDOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
1—— 一个汉字在字符串中是以两个负的字符形式存储，
所以本题只要把字符串中负字符的个数找出来，再除以2 就OK了。

2——汉字机内码在计算机的表达方式的描述是，使用二个字节，每个字节最高位一位为1。 
计算机中， 补码第一位是符号位， 1 表示为 负数，
 所以 汉字机内码的每个字节表示的十进制数都是负数
 
 (1)概念：在计算机内部表示汉字的代码。
 (2)特点：汉字内码采用两个字节，一个汉字占两个ASCII字符；汉字内码最高位为1，ASCII码最高位为0
 (3)汉字内码与区位码的关系：
汉字内码高位字节=(区号)16+(A0)16
汉字内码低位字节=(位号)16+(A0)16
 例3：汉字“啊”的区位码为1601，则其汉字内码为(B0A1)16。
 * @author Andy
 *
 */
public class _2030 {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in,"UTF-8")));
		int n=sc.nextInt(), sum=0;
		sc.nextLine();//读入n后面的回车
		for (int i = 0; i < n; i++) {
			sum=0;
			byte[] b= sc.nextLine().getBytes();
			for (int j = 0; j < b.length; j++) {
				if(b[j]<0) sum++;
			}
			System.out.println(sum/3);
		}
	}
}

//public static void main(String[] args) throws IOException {
//	Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//	int n=sc.nextInt(), sum=0;
//	String regEx = "[\\u4e00-\\u9fa5]";
//	Pattern p = Pattern.compile(regEx);
//	sc.nextLine();//读入n后面的回车
//	for (int i = 0; i < n; i++) {
//		StringBuilder sb=new StringBuilder(sc.nextLine());
//		sum=0;
//		Matcher m = p.matcher(sb);
//		while (m.find()) sum++;
//		System.out.println(sum);
//	}
//}