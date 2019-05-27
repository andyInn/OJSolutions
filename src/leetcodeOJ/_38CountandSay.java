package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _38CountandSay {
    private static Map<Integer, String> m = new HashMap<>();
    static{
        m.put(1, "1");
        for(int i=2;i<=30;i++){
            String s = m.get(i-1);
            int count = 1;
            char ch = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<s.length();j++){
                if(ch!=s.charAt(j)){
                    sb.append(count).append(ch);
                    count = 1;
                    ch = s.charAt(j);
                } else count++;
            }
            sb.append(count).append(ch);
            m.put(i, sb.toString());
        }
    }
    public String countAndSay(int n) {
        if(n<1||n>30) return "1";
        return m.get(n);
    }

}
