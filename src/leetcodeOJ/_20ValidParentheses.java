package leetcodeOJ;

import java.util.*;

public class _20ValidParentheses {
    public boolean isValid(String s) {
        if(null == s || s.length()<1) return true;
        if(s.length()<2) return false;
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            if(map.values().contains(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.size()>0&&stack.peek().equals(map.get(s.charAt(i)))) stack.pop();
            else return false;
        }
        return stack.isEmpty()?true:false;
    }

    public boolean isValid2(String s) {
        if (null == s || s.length() < 1) return true;
        while (s.contains("()") || s.contains("{}") || s.contains("[]"))
            s.replaceAll("\\(\\)", "")
                    .replaceAll("\\{\\}", "")
                    .replaceAll("\\[\\]", "");
        return (0 == s.length() ? true : false);
    }
}
