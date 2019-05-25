package leetcodeOJ;

import leetcodeOJ.ListNode;

public class _25ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) return head;
        int len = 0, index = 0, round = 0;
        ListNode left = null, p1 = head, p2 = head.next;
        while (null != p1) {
            len++;
            p1 = p1.next;
        }
        if (len < k) return head;
        p1 = head;
        while (round++ < len / k) {
            //revert
            while (null != p1 && index < k * round) {
                if (1 == round) {
                    p1.next = left;
                    left = p1;
                } else {
                    p1.next = left.next;
                    left.next = p1;
                }
                p1 = p2;
                if (null == p2) break;
                p2 = p2.next;
                index++;
            }
            if (1 == round) head = left;
            //update left to prior p2
            while (null != left.next) left = left.next;
        }
        left.next = p1;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        root.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode result = new _25ReverseNodesinkGroup().reverseKGroup(root, 5);
        while(null!=result){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
