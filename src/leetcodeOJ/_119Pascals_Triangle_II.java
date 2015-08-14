package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

public class _119Pascals_Triangle_II {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		if (rowIndex == 0) {
			return li;
		}
		li.add(1);
		if (rowIndex == 1) {
			return li;
		}
		li.remove(1);
		int[] a = new int[rowIndex + 1];
		a[0] = a[1] = 1;
		for (int i = 1; i <= rowIndex; i++) {// rowIndex次运算
			for (int j = i - 1; j >= 1; j--) {// cal inner part, avoid override value
				a[j] += a[j - 1];
			}
			a[i]=1;
		}// for
		for (int j = 1; j <= rowIndex; j++) {
			li.add(a[j]);
		}
		return li;
	}

	public static void main(String[] args) {
		System.out.println(getRow(5));
	}
}
