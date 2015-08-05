package HDOJ;

import java.io.IOException;
import java.util.Scanner;

public class _2027 {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		StringBuilder s = new StringBuilder();
		int n=sc.nextInt();
		sc.nextLine();//读入n后面的回车
		for (int i = 0; i < n; i++) {
			int pa=0,pe=0,pi=0,po=0,pu=0;
			s.delete(0, s.length());
			s.append(sc.nextLine());
			for (int j = 0; j < s.length();) {
				switch (s.charAt(j)) {
				case 'a': pa++; j++; continue;
				case 'e': pe++; j++; continue;
				case 'i': pi++; j++; continue;
				case 'o': po++; j++; continue;
				case 'u': pu++; j++; continue;
				default: j++;
				}
			}//for
			System.out.println("a:"+pa);
			System.out.println("e:"+pe);
			System.out.println("i:"+pi);
			System.out.println("o:"+po);
			System.out.println("u:"+pu);
			if(i!=n-1) System.out.println("");
		}
	}
}
