package leetcodeOJ;

public class _012IntegerToRoman {
	public static String intToRoman(int num) {
		String[][] roman = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" }
			};
		StringBuilder ret = new StringBuilder();
		int digit = 0;
		while (num != 0) {
			int remain = num % 10;
			ret = new StringBuilder(roman[digit][remain]).append(ret);
			digit++;
			num /= 10;
		}
		return ret.toString();
	}

	public static void main(String... strings) {
		System.out.println(intToRoman(3999));
	}
}