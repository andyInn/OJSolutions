package HDOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2043 {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in,"UTF-8")));
		int n=sc.nextInt(), sum=0;
		sc.nextLine();//读入n后面的回车
		String regExDigit = "[0-9]";
		String regExLow = "[a-z]";
		String regExHigh = "[A-Z]";
		String regExOthers = "[~!@#$%^]";
		Pattern p1 = Pattern.compile(regExDigit);
		Pattern p2 = Pattern.compile(regExLow);
		Pattern p3 = Pattern.compile(regExHigh);
		Pattern p4 = Pattern.compile(regExOthers);
		for (int i = 0; i < n; i++) {
			StringBuilder sb=new StringBuilder(sc.nextLine());
			sum=0;
			Matcher m1 = p1.matcher(sb);
			Matcher m2 = p2.matcher(sb);
			Matcher m3 = p3.matcher(sb);
			Matcher m4 = p4.matcher(sb);
			if(sb.length()<8||sb.length()>16){
				System.out.println("NO");
				continue;
			}
			if(m1.find()) sum++;
			if(m2.find()) sum++;
			if(m3.find()) sum++;
			if(m4.find()) sum++;
			if(sum>2) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}