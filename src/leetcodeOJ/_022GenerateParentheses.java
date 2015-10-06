package leetcodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class _022GenerateParentheses {
	/*public static List<String> generateParenthesis(int n) {
		List<String> res = new CopyOnWriteArrayList<String>();
		res.add("");
		int start = 0;
		for (int i = 1; i <= n; i++) {
			int end = res.size();
			for (int j = start; j < end; j++) {
				res.add("(" + res.get(j) + ")");
				if (res.indexOf("()" + res.get(j)) == -1) {
					res.add("()" + res.get(j));
				}
				if (res.indexOf(res.get(j) + "()") == -1) {
					res.add(res.get(j) + "()");
				}
			}
			start = end;
		}// for
		while(start-- >0){
			res.remove(start);
		}
		return res;
	}
	
	public static List<String> generateParenthesis2(int n) {
		List<String> list = new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		res.add("");
		String s = "";
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < res.size(); j++) {
				s = res.get(j);
				list.add("(" + s + ")");
				if (res.indexOf("()" + s) == -1 && list.indexOf("()" + s) == -1) {
					list.add("()" + s);
				}
				if (res.indexOf(s + "()") == -1 && list.indexOf(s + "()") == -1) {
					list.add(s + "()");
				}
			}// for
			res = new ArrayList<String>(Arrays.asList(new String[list.size()]));
			Collections.copy(res, list);
			list.clear();
		}// for
		return res;
	}*/
	/**
	 * @param left 左括号的个数
	 * @param right 右括号的个数
	 * @param str 当前已经完成的那部分str
	 * @param list 保存结果用
	 */
	public static void getParen(int left, int right, String str, List<String> list) {
		if (left == 0 && right == 0) {
			list.add(str);
		} else if (left == right) {
			str += "(";
			getParen(left - 1, right, str, list);
		} else {
			if (left > 0) {
				String strLeft = str + "(";
				getParen(left - 1, right, strLeft, list);
			}
			if (right > 0) {
				String strRight = str + ")";
				getParen(left, right - 1, strRight, list);
			}
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		String str = "";
		getParen(n, n, str, list);
		return list;
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(4);
		System.out.println(res.size());
		for (String s : res) {
			System.out.println(s);
		}
	}
}
