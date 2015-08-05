package HDOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RikkaWithString {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(sc.hasNext()){
			int n=sc.nextInt();
			sc.nextLine();//读入回车
			StringBuilder sb=new StringBuilder();
			sb.append(sc.nextLine());
			int len=(n>>1), i = 0, lenN=0, count=0, count2=0,pMax=0;
			boolean flag=false;
			int[] a=new int[1000];
			while (i < len) {
				if(sb.charAt(i)=='?'&&sb.charAt(n-1-i)=='?'){
					sb.deleteCharAt(i);
					sb.insert(i, 'a');
					sb.deleteCharAt(n-1-i);
					sb.insert(n-1-i, 'b');
					i++;
					flag=true;
					continue;
				}
				if(sb.charAt(i)=='?'){
					sb.deleteCharAt(i);
					sb.insert(i, 'a');
					if(sb.charAt(i)==sb.charAt(n-1-i))
						count2++;
					a[lenN]=i; pMax=pMax>i?pMax:i;
					i++; lenN++;
					continue;
				}
				if(sb.charAt(n-1-i)=='?'){
					sb.deleteCharAt(n - 1 - i);
					sb.insert(n - 1 - i, 'a');
					if(sb.charAt(i)==sb.charAt(n-1-i))
						count2++;
					a[lenN]=n-1-i;pMax=pMax>n-1-i?pMax:n-1-i;
					i++; lenN++;
					continue;
				}
				if(sb.charAt(i)==sb.charAt(n-1-i)) {
					count++; 
				}
				i++;
			}//for
			if(count==len){
				System.out.println("QwQ");
				continue;
			}
			int mid=len+1;
			if(n%2==1 && sb.charAt(mid)=='?'){
				sb.deleteCharAt(mid);
				sb.insert(mid, 'a');
			}//if
			//检查一遍?所在位置是否构成回文串
			if(flag==false&&(count2+count)==len){
				if(sb.charAt(pMax)==sb.charAt(n-1-pMax)){
					char ch=(sb.charAt(n-1-pMax)=='a')?'b':'a';
					sb.deleteCharAt(pMax);
					sb.insert(pMax, ch);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
