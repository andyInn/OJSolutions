package leetcodeOJ;

public class _28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(null==haystack || null==needle || 0==needle.length()) return 0;
        int i=0, p1 = 0, p2 = 0;
        for(i=0;i+needle.length()<=haystack.length();i++){
            for(p1 = i, p2 = 0;i+needle.length()<=haystack.length()&&p2<needle.length();p2++){
                if(haystack.charAt(p1)==needle.charAt(p2)){
                    p1++;
                    if(needle.length()+i==p1) return i;
                } else break;
            }
            if(i+needle.length()>=haystack.length()) break;
        }
        return -1;
    }

    public static void main(String[] args) {
//        String haystack, String needle = "";
        System.out.println(new _28ImplementstrStr().strStr("a","a"));
        System.out.println(new _28ImplementstrStr().strStr("abc","abc"));
        System.out.println(new _28ImplementstrStr().strStr("abc","bc"));
        System.out.println(new _28ImplementstrStr().strStr("abc","bcd"));
        System.out.println(new _28ImplementstrStr().strStr("abc","abcdefg"));
        System.out.println(new _28ImplementstrStr().strStr("hello","ll"));
        System.out.println(new _28ImplementstrStr().strStr("hello","he"));
        System.out.println(new _28ImplementstrStr().strStr("",""));
        System.out.println(new _28ImplementstrStr().strStr("","bb"));
        System.out.println(new _28ImplementstrStr().strStr("hello","bye"));
    }
}
