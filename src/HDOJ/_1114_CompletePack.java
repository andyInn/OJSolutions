package HDOJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _1114_CompletePack{
	public static int min(int a, int b){
		return a > b ? b : a;
	}

	public static void main(String[] args){
		Scanner sc=null;
		try {
			sc=new Scanner(new File("src/HDOJ/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int T=sc.nextInt();
		while(T-- >0){
			int E = sc.nextInt(), F = sc.nextInt(), N = sc.nextInt();
			int tw=F-E,mini=0;
			int[] P = new int[N + 1], W = new int[N + 1], res = new int[tw + 1];
			for(int i=1;i<=N;i++){
				P[i]=sc.nextInt();
				W[i]=sc.nextInt();
			}
			int MINIMAL = -32767;
			Arrays.fill(res, MINIMAL);
			res[0] = 0;// 刚好装满的效果
			for (int i = 1; i < N; i++) {
				for (int j = W[i]; j <= tw; j++) {
					res[j] = min(res[j], res[j - W[i]] + P[i]);
					if (j == tw) {
						if (mini == 0) {
							mini = res[j];
						} else {
							mini = min(mini, res[j]);
						}
					}
				}
			}// for
			if (mini == 0) {
				System.out.println("This is impossible.");
			} else {
				System.out.println(
					"The minimum amount of money in the piggy-bank is " + mini + ".");
			}
		}
	}
}
