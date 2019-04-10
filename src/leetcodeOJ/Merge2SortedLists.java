package leetcodeOJ;

public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = null;
        if(l1.val<l2.val) res=l1;
        while(l1.next!=null&&l2.next!=null){
            //
        }

    }

    public static void main(String[] args) {
//        System.out.println(new Merge2SortedLists().mergeTwoLists());
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
