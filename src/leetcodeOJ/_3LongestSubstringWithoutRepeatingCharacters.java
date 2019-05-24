package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;
        if (s.length() < 2) return s.length();
        int len = 1, left = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i)) && m.get(s.charAt(i)) + 1 > left) {
                left = m.get(s.charAt(i)) + 1;
            }
            m.put(s.charAt(i), i);
            len = i - left + 1 > len ? i - left + 1 : len;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdvabcdvvvvdf"));
        System.out.println(new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("xyzdvdvabcdvvvvdf"));
    }
}
