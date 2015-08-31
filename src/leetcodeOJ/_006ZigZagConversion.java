package leetcodeOJ;

/**
 * 根据上图，我们发现如下规律,这里我们假设我们分成m排： 1 第i排从i开始 2 第i排两个数的间隔是2(i-1),2(m-i)交替。
 * @author Andy
 * 
 */
public class _006ZigZagConversion {
	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int step = (numRows - 1) << 1;
		for (int row = 0; row < numRows; row++) {
			for (int j = row; j < s.length(); j += step) {
				sb.append(s.charAt(j));
				if (row == 0 || row == numRows - 1)
					continue;
				// 如果不是第一行或者最后一行，则还有一个斜线上的数据
				int slash = j + step - (row << 1);
				if (slash < s.length())
					sb.append(s.charAt(slash));
			}
		}
		return sb.toString();
	}
	
	public static void main(String ...strings){
		System.out.println(convert("123456789",	4));
	}
}
