package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1019NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            nums.add(p.val);
            p=p.next;
        }

        Stack<Integer> ss = new Stack<>();
        int[] ans = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            while(!ss.empty()&&nums.get(ss.peek())<nums.get(i)){
                int t=ss.peek();
                ss.pop();
                ans[t]=nums.get(i);
            }
            ss.push(i);
        }
        return ans;
    }
}
