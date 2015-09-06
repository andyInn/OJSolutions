package niuke.mianshijindian;

public class _003确定字符互异 {
	public static boolean checkDifferent(String iniString) {
		if (iniString == null || iniString.length() < 2)
			return true;
		StringBuilder sb = new StringBuilder(iniString);
		int len = sb.length();
		for (int i = 0; i < len; i++) {
			if (i + 1 < len && sb.substring(i + 1).contains(String.valueOf(iniString.charAt(i))))
				return false;
		}
		return true;
	}
	
	public static void main(String ...strings){
		System.out.println(checkDifferent("aAbcd"));
	}
}
