package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _12Integet2Roman {
    static final Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "");
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(5, "V");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(50, "L");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(500, "D");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");

        map.put(4, "IV");
        map.put(6, "VI");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(60, "LX");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(600, "DC");
        map.put(900, "CM");
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        String res = "";
        int unit = 1, step = 10, len = String.valueOf(num).length();
        while (len-- > 0) {
            res = map.get(unit * (num % 10)) + res;
            num /= 10;
            unit *= step;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new _12Integet2Roman().intToRoman(0));
//        System.out.println(new _12Integet2Roman().intToRoman(1));
//        System.out.println(new _12Integet2Roman().intToRoman(3));
//        System.out.println(new _12Integet2Roman().intToRoman(4));
//        System.out.println(new _12Integet2Roman().intToRoman(7));
//        System.out.println(new _12Integet2Roman().intToRoman(9));
//        System.out.println(new _12Integet2Roman().intToRoman(11));
        System.out.println(new _12Integet2Roman().intToRoman(58));
        System.out.println(new _12Integet2Roman().intToRoman(99));
        System.out.println(new _12Integet2Roman().intToRoman(1994));
        System.out.println(new _12Integet2Roman().intToRoman(44));
        System.out.println(new _12Integet2Roman().intToRoman(400));
        System.out.println(new _12Integet2Roman().intToRoman(222));
        System.out.println(new _12Integet2Roman().intToRoman(3999));
    }
}
