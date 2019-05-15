package leetcodeOJ;

import java.util.Arrays;

public class _455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(null==g||g.length<1||null==s||s.length<1) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        for(int i=0, j=0; i<g.length && j<s.length; i++, j++){
            while(j<s.length&&g[i]>s[j]) j++;
            if(j<s.length) sum++;
        }
        return sum;
    }
}
