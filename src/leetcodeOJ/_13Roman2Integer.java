package leetcodeOJ;


import java.util.HashMap;
import java.util.Map;

public class _13Roman2Integer {
    final static Map<Character, Integer> symbol = new HashMap<Character, Integer>();
    final static Map<String, Integer> symbol2 = new HashMap<String, Integer>();
    static {
        symbol.put('I', 1);
        symbol.put('V', 5);
        symbol.put('X', 10);
        symbol.put('L', 50);
        symbol.put('C', 100);
        symbol.put('D', 500);
        symbol.put('M', 1000);

        symbol2.put("IV", 4);
        symbol2.put("VI", 6);
        symbol2.put("IX", 9);
        symbol2.put("XI", 11);
        symbol2.put("XL", 40);
        symbol2.put("LX", 60);
        symbol2.put("XC", 90);
        symbol2.put("CX", 110);
        symbol2.put("CD", 400);
        symbol2.put("DC", 600);
        symbol2.put("CM", 900);
        symbol2.put("MC", 1100);
    }
    public int romanToInt(String s) {
        if (s == null || s.length() < 1) return -1;
        if (s.length() < 2) return symbol.get(s.charAt(0));
        int res = 0, cur = 0, pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            cur = symbol.get(s.charAt(i));
            if (i - 1 >= 0) {
                pre = symbol.get(s.charAt(i - 1));
                if (cur <= pre) res += cur;
                else {
                    res += symbol2.get(s.substring(i - 1, i + 1));
                    i--;
                }
            } else {
                res += cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _13Roman2Integer().romanToInt("III"));
        System.out.println(new _13Roman2Integer().romanToInt("IV"));
        System.out.println(new _13Roman2Integer().romanToInt("IX"));
        System.out.println(new _13Roman2Integer().romanToInt("LVIII"));
        System.out.println(new _13Roman2Integer().romanToInt("MCMXCIV"));
        System.out.println(new _13Roman2Integer().romanToInt("MCXI"));
        System.out.println(new _13Roman2Integer().romanToInt("CMXC"));
    }
}
