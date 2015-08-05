package com.cun.ei;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BM {
	// 优化过后的next 数组求法
	int[] GetNextval(StringBuilder modeStr) {
		int pLen = modeStr.length();
		int[] next = new int[pLen];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < pLen - 1) {
			// p[k]表示前缀，p[j]表示后缀
			if (k == -1 || modeStr.charAt(j) == modeStr.charAt(k)) {
				++j;
				++k;
				// 较之前next数组求法，改动在下面4行
				if (modeStr.charAt(j) != modeStr.charAt(k))
					next[j] = k; // 之前只有这一行
				else
					// 因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] =
					// next[next[k]]
					next[j] = next[k];
			} else {
				k = next[k];
			}
		}
		return next;
	}

	int KmpSearch(StringBuilder textStr, StringBuilder modeStr, int[] next) {
		int i = 0;
		int j = 0;
		int sLen = textStr.length();
		int pLen = modeStr.length();
		while (i < sLen && j < pLen) {
			// ①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
			if (j == -1 || textStr.charAt(i) == modeStr.charAt(j)) {
				i++;
				j++;
			} else {
				// ②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
				// next[j]即为j所对应的next值
				j = next[j];
			}
		}
		if (j == pLen)
			return i - j;
		else
			return -1;
	}

	public static void main(String[] args) throws IOException {
		String path = "D:/Bible.txt";
		BM ki = new BM();
		long starTime = System.currentTimeMillis(), count = 0l;
		int mi=7;
		double n=Math.pow(2, mi);
		int res = 0, N = (int) n;
//		String _line = "Truly, truly, I say to you, unless one is born again he cannot see the kingdom of God";
//		String _line = "You shall know the truth and the truth shall set you free.";
//		String _line = "Most assuredly, I say to you, unless one is born again, he cannot see the kingdom of God";
		String _line = "Holy, holy, holy is the LORD of hosts; The whole earth is full of His glory!";
		StringBuilder sb = new StringBuilder(_line);
		int[] next = ki.GetNextval(sb);
		for (int i = 0; i < N; i++) {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			StringBuilder line = new StringBuilder(br.readLine());
			while (line != null) {
				res = ki.KmpSearch(line, sb, next);
				if(res!=-1) break;
				System.out.println("line:" + ++count);
				if ((_line = br.readLine()) == null)
					break;
				line = new StringBuilder(_line);
			}
		}
		long endTime = System.currentTimeMillis();
		long last = (endTime - starTime);// >> mi;
		System.out.println("运行时间为：" + last);
	}
}
