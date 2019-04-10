package leetcodeOJ;

public class String2Integer_atoi {
    public int myAtoi(String str) {
        if (str == null || str.length() < 1) return 0;
        StringBuilder sb = new StringBuilder();
        boolean isPreBlank = true, isStart = false;
        for (int i = 0; i < str.length(); i++) {
            if (isPreBlank == true && str.charAt(i) == ' ') continue;
            isPreBlank = false;
            if (isStart == false) {
                if (str.charAt(i) == '+' || str.charAt(i) == '-' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    sb.append(str.charAt(i) == '+' ? "" : str.charAt(i));
                    isStart = true;
                } else {
                    return 0;
                }
            } else {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                } else {
                    break;
                }
            }
        }
        if (sb.length() == 0) return 0;
        //judge number
        Integer res = getInteger(sb.toString());
        return null == res ? 0 : res;
    }

    private Integer getInteger(String string) {
        if (string.length() < 2 && string.charAt(0) == '-') return null;
        int i;
        if (string.charAt(0) == '-') {
            for (i = 1; i < string.length(); i++) {
                if (string.charAt(i) == '0') continue;
                break;
            }
            if(i==string.length()) return null;
            string = '-' + string.substring(i);
            if (string.length() > 11 || Long.valueOf(string) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            for (i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '0') continue;
                break;
            }
            if(i==string.length()) return null;
            string = string.substring(i);
            if (string.length() > 10 || Long.valueOf(string) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.valueOf(string);
    }

    public static void main(String[] args) {
        System.out.println(new String2Integer_atoi().myAtoi("-"));
        System.out.println(new String2Integer_atoi().myAtoi("+"));
        System.out.println(new String2Integer_atoi().myAtoi("9"));
        System.out.println(new String2Integer_atoi().myAtoi("42"));
        System.out.println(new String2Integer_atoi().myAtoi("-42"));
        System.out.println(new String2Integer_atoi().myAtoi("4193 with words"));
        System.out.println(new String2Integer_atoi().myAtoi(" +4193 with words"));
        System.out.println(new String2Integer_atoi().myAtoi("   -4193 with words"));
        System.out.println(new String2Integer_atoi().myAtoi("   4193 with words"));
        System.out.println(new String2Integer_atoi().myAtoi("words and 987"));
        System.out.println(new String2Integer_atoi().myAtoi("*97"));
        System.out.println(new String2Integer_atoi().myAtoi("$"));
        System.out.println(new String2Integer_atoi().myAtoi("-91283472332"));
        System.out.println(new String2Integer_atoi().myAtoi("2147483648"));
        System.out.println(new String2Integer_atoi().myAtoi("20000000000000000000"));
        System.out.println(new String2Integer_atoi().myAtoi("2000000000000000000020000000000000000000"));
        System.out.println(new String2Integer_atoi().myAtoi("-2000000000000000000020000000000000000000"));
        System.out.println(new String2Integer_atoi().myAtoi("  00000000000123456780000000000012345678"));
        System.out.println(new String2Integer_atoi().myAtoi("  0000000000012345678"));
        System.out.println(new String2Integer_atoi().myAtoi("  -00000000000123456780000000000012345678"));
        System.out.println(new String2Integer_atoi().myAtoi("  -0000000000012345678"));
        System.out.println(new String2Integer_atoi().myAtoi("    -0000000000000   "));
        System.out.println(new String2Integer_atoi().myAtoi("    0000000000000   "));
    }
}
