package niuke.mianshijindian;

public class _001空格替换 {
	public static String replaceSpace(String iniString, int length) {
        if(iniString==null)
        	return iniString;
        if(length==0)
        	return "";
        return iniString.replaceAll(" ", "%20");
    }
	
	public static void main(String ...strings){
		System.out.println(replaceSpace("", 13));
	}
}
