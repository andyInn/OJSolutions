package com.cun.ei;

import java.io.IOException;

public class Kmp_general {
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

	int[] GetNext(StringBuilder modeStr) {
		int pLen = modeStr.length();
		int[] next = new int[pLen];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < pLen - 1) {
			// p[k]表示前缀，p[j]表示后缀
			if (k == -1 || modeStr.charAt(j) == modeStr.charAt(k)) {
				++k;
				++j;
				next[j] = k;
			}else {
				k = next[k];
			}
		}//while
		return next;
	}

	public static void main(String[] args) throws IOException {
		String path = "D:/Bible.txt";
		Kmp_general kg = new Kmp_general();
		int mi=10;
		double n=Math.pow(2, mi);
		int res = 0, N = (int) n;
		long max = 100000l, _count = 0l;
		String test = "Truly, truly, I say to you, unless one is born again he cannot see the kingdom of God";
//		String _line = "Truly, truly, I say to you, unless one is born again he cannot see the kingdom of God";
//		String _line = "You shall know the truth and the truth shall set you free.";
//		String _line = "Most assuredly, I say to you, unless one is born again, he cannot see the kingdom of God";
//		String _line = "Holy, holy, holy is the LORD of hosts; The whole earth is full of His glory!";
//		String _line = "For you For you, holy, For youholy,For you holyFor you The wholeFor you earthFor you is fullFor youFor youFor you glory!";
		String _line = "";
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
//		StringBuilder line = new StringBuilder(br.readLine());
		StringBuilder line = new StringBuilder(test);
//		while (line != null) {
//			if ((_line = br.readLine()) == null)
//				break;
//			line.append(_line);
//		}
		while((++_count)<max){
			line.append(test);
		}
		System.out.println(line.length());
		_line = "Truly, truly, I say to you, unless one is born again he does nothing~";
		long starTime = System.nanoTime(), count = 0l;
		StringBuilder sb = new StringBuilder(_line);
		int[] next = kg.GetNext(sb);
		for (int i = 0; i < N; i++) {
			res = kg.KmpSearch(line, sb, next);
			if (res != -1){
				i++;
				continue;
			}
			System.out.println("line:" + ++count);
		}
		long endTime = System.nanoTime();
		long last = (endTime - starTime);// >> mi;
		System.out.println("运行时间为：" + last);
	}
}
