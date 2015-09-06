package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字以前只接触过I到VIII，第一次听说罗马数字也可以表示大于8的数字。
 * 阿拉伯数字和罗马数字之间的转换最重的是了解罗马数字的规则。Wiki了一把，又参考了其它的文档，总结如下：
罗马数字规则：

1， 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
罗马数字中没有“0”。
2， 重复次数：一个罗马数字最多重复3次。
3， 右加左减：
在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
4， 左减的数字有限制，仅限于I、X、C，且放在大数的左边只能用一个。
(*) V 和 X 左边的小数字只能用Ⅰ。
(*) L 和 C 左边的小数字只能用X。
(*) D 和 M 左 边的小数字只能用C。
    这里，我们只介绍一下1000以内的数字的表示法。 
    单个符号重复多少次，就表示多少倍。最多重复3次。比如：CCC表示300  XX表示20，但150并不用LLL表示，这个规则仅适用于I X C M。 
    如果相邻级别的大单位在右，小单位在左，表示大单位中扣除小单位。比如：IX表示9  IV表示4  XL表示40 
    古罗马帝国开创了辉煌的人类文明，但他们的数字表示法的确有些繁琐，尤其在表示大数的时候，现在看起来简直不能忍受，所以在现代很少使用了。之所以这样，不是因为发明表示法的人的智力的问题，而是因为一个宗教的原因，当时的宗教禁止在数字中出现0的概念！ 
    罗马数字的表示主要依赖以下几个基本符号： 
    I  1 
    V  5 
    X  10 
    L  50 
    C  100 
    D  500 
    M  1000 
    这里，我们只介绍一下1000以内的数字的表示法。 
    单个符号重复多少次，就表示多少倍。最多重复3次。比如：CCC表示300  XX表示20，但150并不用LLL表示，这个规则仅适用于I X C M。 
    如果相邻级别的大单位在右，小单位在左，表示大单位中扣除小单位。比如：IX表示9  IV表示4  XL表示40 更多的示例参见下表，你找到规律了吗？ 
I,1  
II，2 
III，3 
IV，4 
V，5 
VI，6 
VII，7 
VIII，8 
IX，9  
X，10 
XI，11 
XII，12 
XIII,13 
XIV,14 
XV,15 
XVI,16 
XVII,17 
XVIII,18 
XIX,19 
XX,20 
XXI,21 
XXII,22 
XXIX,29 
XXX,30 
XXXIV,34 
XXXV,35 
XXXIX,39 
XL,40 
L,50 
LI,51 
LV,55 
LX,60 
LXV,65 
LXXX,80 
XC,90 
XCIII,93 
XCV,95 
XCVIII,98 
XCIX,99 
C,100 
CC,200 
CCC,300 
CD,400 
D,500 
DC,600 
DCC,700 
DCCC,800 
CM,900 
CMXCIX,999
 * @author Andy
 *
 */
public class _013RomanToInteger {
	public static int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int sum = toNumber(s.charAt(0)), a = 0, b = 0;
		for (int i = 1; i < s.length(); i++) {
			a = toNumber(s.charAt(i-1));
			b = toNumber(s.charAt(i));
			if (a < b) {
				sum += b - 2 * a;
			} else {
				sum += b;
			}
		}
		return sum;
	}
	
	public static int romanToInt2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Map<Character, Integer> dct = new HashMap<Character, Integer>();
		dct.put('I', 1);
		dct.put('V', 5);
		dct.put('X', 10);
		dct.put('L', 50);
		dct.put('C', 100);
		dct.put('D', 500);
		dct.put('M', 1000);
		int sum = 0, len = s.length();
		char b;
		for (int i = 0; i < len; ++i) {
			b = s.charAt(i);
			if (i + 1 < len && dct.get(s.charAt(i + 1)) > dct.get(b)) {
				sum += dct.get(s.charAt(i + 1)) - dct.get(b);
				i++;
			} else
				sum += dct.get(b);
		}
		return sum;
	}
	
	public static int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

	public static void main(String... strings) {
		System.out.println(romanToInt2("CMXCIX"));
	}
}