package leetcodeOJ;
/**
 * http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840437.html
 * Gray Code， 每次看每次都不记得。写下来让自己好温习。
Gray Code 0 = 0, 下一项是toggle最右边的bit(LSB), 再下一项是toggle最右边值为 “1” bit的左边一个bit。然后重复

如： 3bit
Gray Code:  000, 001, 011, 010, 110, 111, 101, 100, 最右边值为 “1” 的bit在最左边了，结束。
Binary   :  000, 001, 010, 011, 100, 101, 110, 111

再者就是Binary Code 转换为Gray Code了。
如：
　　Binary Code ：1011 要转换成Gray Code
　　1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 1(第二位异或第三位， 0^1=1), 0 (1^1 =0) = 1110
　　其实就等于 (1011 >> 1) ^ 1011 = 1110
 */
import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> li = new ArrayList<Integer>();
		if (n == 0) {
			li.add(0);
			return li;
		}
		li.add(0);
		li.add(1);
		if (n == 1)
			return li;
		for (int i = 2; i <= n; i++) {
			for (int j = (int) Math.pow(2, i - 1); j >= 1; j--) {
				li.add((1 << (i - 1)) | li.get(j - 1));
			}
		}
		return li;
	}
	
	public static List<Integer> grayCode2(int n) {
		List<Integer> li = new ArrayList<Integer>();
		int size = 1 << n;
		for (int i = 0; i < size; i++) {
			int gCode = i ^ (i >> 1);
			li.add(gCode);
		}
		return li;
	}

	public static void main(String[] args) {
		System.out.println(grayCode2(3));
	}
}