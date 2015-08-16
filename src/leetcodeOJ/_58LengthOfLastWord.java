package leetcodeOJ;

public class _58LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0 || s.equals(" ")) {
			return 0;
		}
		int len = 0, tmp = 0;
		String[] a = s.split(" ");
		for (String string : a) {
			tmp = string.length();
			if (tmp != 0)
				len = tmp;
		}
		return len;
	}

	public static void main(String[] args) {
		String s="Hello";
		System.out.println(lengthOfLastWord(s));
	}
}
