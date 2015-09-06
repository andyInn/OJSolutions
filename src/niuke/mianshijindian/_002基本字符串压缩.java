package niuke.mianshijindian;

public class _002基本字符串压缩 {
	public static String zipString(String iniString) {
		if (iniString == null || iniString.length() <= 2)
			return iniString;
		StringBuilder sb = new StringBuilder();
		char left = iniString.charAt(0);
		int count = 1;
		sb.append(left);
		for (int i = 1; i < iniString.length(); i++) {
			if (iniString.charAt(i) == left) {
				count++;
				continue;
			} else {
				sb.append(count);
				left = iniString.charAt(i);
				sb.append(left);
				count = 1;
			}
		}// for
		sb.append(count);
		return sb.length() < iniString.length() ? sb.toString() : iniString;
	}
	
	public static void main(String ...strings){
		System.out.println(zipString("aabbbbbba"));
	}
}
