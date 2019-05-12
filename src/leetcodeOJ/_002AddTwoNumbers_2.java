package leetcodeOJ;

public class _002AddTwoNumbers_2 {
    /**
     * 3 blockers,
     * that number does not start with 0 means list will not end with 0 except for integer 0
     * reference will be used in case it is not null
     * increment will not update if l1 or l2 has only one node
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode result = null, p1 = l1, p2 = l2, worker = result;
        boolean increment = false;
        int sum = 0;
        while((null!=p1 && p1.next!=null) || (null!=p2 && p2.next!=null)){
            sum = (null==p1?0:p1.val) + (null==p2?0:p2.val) + (increment?1:0);
            increment = sum>9?true:false;
            ListNode temp = new ListNode(sum>9?sum%10:sum);
            temp.next = null;
            if(worker!=null){
                worker.next = temp;
            }
            worker = temp;
            if(result==null) result = temp;
            if(null!=p1)p1 = p1.next;
            if(null!=p2)p2 = p2.next;
        }

        if(increment || p1!=null || p2!=null){
            sum = (null==p1?0:p1.val) + (null==p2?0:p2.val) + (increment?1:0);
            increment = sum>9?true:false;
            ListNode temp = new ListNode(sum>9?sum%10:sum);
            temp.next = null;
            if(worker!=null){
                worker.next = temp;
            }
            worker = temp;
            if(result==null) result = temp;
        }

        if(increment){
            ListNode temp = new ListNode(1);
            temp.next = null;
            worker.next = temp;
        }
        return result;
    }
}
