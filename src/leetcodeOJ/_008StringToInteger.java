package leetcodeOJ;

import java.math.BigInteger;

public class _008StringToInteger {
	/**
	 * BigInteger实现
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		if (str == null)
			return 0;
		int i = 0, sign = 1;
		StringBuilder sb = new StringBuilder();
		while (i < str.length() && str.charAt(i) == ' ')
			i++;
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			if (str.charAt(i++) == '-')// 因i肯定要自增1，故放在了这里
				sign = -1;
		}
		while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
			sb.append(str.charAt(i++));
		}
		if (sb.length() > 0) {
			BigInteger bi = new BigInteger(sb.toString());
			if (bi.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1) {
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			return sign * bi.intValue();
		}
		return 0;
	}
	/**
	 * Long实现
	 * @param str
	 * @return
	 */
	public static int myAtoi2(String str) {
		if (str == null)
			return 0;
		int i = 0, sign = 1;
		long res_l = 0l;
		StringBuilder sb = new StringBuilder();
		while (i < str.length() && str.charAt(i) == ' ')
			i++;
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			if (str.charAt(i++) == '-')//因i肯定要自增1，故放在了这里
				sign = -1;
		}
		while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
			sb.append(str.charAt(i++));
		}
		if (sb.length() > 0) {
			res_l = Long.parseLong(sb.toString());
			if (res_l > Integer.MAX_VALUE) {
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			return (int) (sign * res_l);
		}
		return 0;
	}
	/**
	 * 通用实现
	 * @param str
	 * @return
	 */
	public static int myAtoi3(String str) {
		if (str == null)
			return 0;
		int i = 0, sign = 1;
		StringBuilder sb = new StringBuilder();
		while (i < str.length() && str.charAt(i) == ' ')
			i++;
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			if (str.charAt(i++) == '-')//因i肯定要自增1，故放在了这里
				sign = -1;
		}
		while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
			sb.append(str.charAt(i++));
		}
		if (sb.length() > 0) {
			if (sb.length() > 10) {// Integer.MAX_VALUE正好10位：2147483647,
				//同时避免了Java无法用long表示C++里面long long范围的个别数，如9223372036854775809
				//主要是OJ无法识别BigInteger，擦！
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			return (int) (sign * Integer.parseInt(sb.toString()));
		}
		return 0;
	}

	public static void main(String... strings) {
//		System.out.println(myAtoi3(String.valueOf(Integer.MAX_VALUE + 10l)));
//		System.out.println(myAtoi3("9223372036854775809"));
//		System.out.println(myAtoi3(""));
//		System.out.println(myAtoi3("  -"));
//		System.out.println(myAtoi3("  - "));
//		System.out.println(myAtoi3("+0000   "));
//		System.out.println(myAtoi3("  -123"));
//		System.out.println(myAtoi3("  +9999"));
//		System.out.println(myAtoi3(" 111  "));
//		System.out.println(myAtoi3("  -0023"));
//		System.out.println(myAtoi3(" 900  "));
//		System.out.println(Long.MAX_VALUE);
		System.out.println(String.valueOf(Double.MAX_VALUE));
	}
}
