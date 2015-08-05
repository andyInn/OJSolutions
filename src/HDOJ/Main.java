package HDOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 2045 前n-2个已涂好后，涂第n-1个即有2种情况： 1. n-1的色与n-2和1的色都不相同，那么n就是剩下的那个色，米选择。 即就是f(n-1)
 * 2. n-1的色与n-2不相同但与1个色一样，那么n的色就有2个色选择. 即就是f(n-2)*2
 * 
 * 综上得：f(n) = f(n-1) + 2*f(n-2); 别忘了验算得出n的范围。
 * 
 * @author Andy
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in, "UTF-8")));
		int n = 0;
		// sc.nextLine();//读入n后面的回车
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n == 1) {
				System.out.println(3);
				continue;
			}
			if (n == 2 || n == 3) {
				System.out.println(6);
				continue;
			}
			BigInteger[] a = new BigInteger[51];
			a[1] = new BigInteger("3");
			a[2] = new BigInteger("6");
			a[3] = new BigInteger("6");
			for (int i = 4; i <= n; i++)
				a[i] = a[i - 1].add(a[i - 2].multiply(new BigInteger("2")));
			System.out.println(a[n]);
		}// while
	}
}