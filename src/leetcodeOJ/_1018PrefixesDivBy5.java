package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

public class _1018PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int t=0;
        for(int n:A){
            t=(t*2+n)%5;
            ans.add(t==0);
        }
        return ans;
    }
}
