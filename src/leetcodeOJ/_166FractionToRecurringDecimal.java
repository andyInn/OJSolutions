package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _166FractionToRecurringDecimal  {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        
        StringBuilder ans = new StringBuilder();
        
        //如果结果为负数
        if ((numerator < 0) ^ (denominator < 0)) {
            ans.append("-");
        }
        
        //下面要把两个数都转为正数，为避免溢出，int转为long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //结果的整数部分
        long res = num / den;
        ans.append(String.valueOf(res));
        
        //如果能够整除，返回结果
        long rem = (num % den) * 10;
        if (rem == 0) return ans.toString();
        
        //结果的小数部分
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        ans.append(".");
        while (rem != 0) {
            //如果前面已经出现过该余数，那么将会开始循环
            if (map.containsKey(rem)) {
                int beg = map.get(rem); //循环体开始的位置
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans.delete(0, ans.length());
                ans.append(part1).append("(").append(part2).append(")");
                return ans.toString();
            }
            
            //继续往下除
            map.put(rem, ans.length());
            res = rem / den;
            ans.append(String.valueOf(res));
            rem = (rem % den) * 10;
        }
        return ans.toString();
    }
    
    public static void main(String ...strings){
    	System.out.println(fractionToDecimal(1, 7));
//    	System.out.println((-1<0)&(-3<0));
    }
}