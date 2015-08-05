package jiuDuOJ;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Main4 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(System.in);
		int n = 0;int  t = 0;int  sum = 0;int  start = 0;int  end = 0;
        int[] arr = new int[10000];
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int)st.nval;
            }
  
            st.nextToken();
            t = (int)st.nval; sum = 0; start = 0; end = 0;
             
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (!map.containsKey(sum)) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    map.put(sum, list);
                } else {
                    List<Integer> list = map.get(sum);
                    list.add(i);
                }
            }
            sum = 0;
            boolean found = false;
            for (int i = 0; i < n-1; i++) {
                if (map.containsKey(sum+t)) {
                    start = i;
                    List<Integer> list = map.get(sum+t);
                    for (Integer ii : list) {
                        if (ii >= i) {
                            end = ii; found = true; break;
                        }
                    }
                    if (found) break;
                }
                sum += arr[i];
            }
            System.out.println(found ? (++start)+" "+(++end) : "No");
        }
    }
}