package jiuDuOj_Answers;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Main_1554 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(System.in);
        int[] arr = new int[10000];
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int)st.nval;
            }
  
            st.nextToken();
            int t = (int)st.nval, sum = 0, start = 0, end = 0;
             
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
            for (int i = 0; i < n-1; i++) {//若存在多个符合条件的输出，则输出s较小的那个，若仍然存在多个，输出e较小的那个。
                if (map.containsKey(sum+t)) {
                    start = i;
                    List<Integer> list = map.get(sum+t);
                    for (Integer ii : list) {
                        if (ii >= i) {//若仍然存在多个，输出e较小的那个。
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
/**************************************************************
    Problem: 1554
    User: 朱小微
    Language: Java
    Result: Accepted
    Time:1470 ms
    Memory:104628 kb
****************************************************************/