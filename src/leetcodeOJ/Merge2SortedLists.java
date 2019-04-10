package leetcodeOJ;

public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null, pointer = null, temp = null;
        if (l1.val < l2.val) {
            pointer = l1;
            l1 = l1.next;
        } else {
            pointer = l2;
            l2 = l2.next;
        }
        pointer.next = null;
        res = pointer;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            temp.next = null;
            pointer.next = temp;
            pointer = pointer.next;
        }

        if (l1 == null) pointer.next = l2;
        if (l2 == null) pointer.next = l1;
        return res;
    }

    public static void main(String[] args) {
//        String string = "1->2->4, 1->3->4";
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(7);

        ListNode result1 = new Merge2SortedLists().mergeTwoLists(null, null);
        while (result1 != null) {
            System.out.print(result1.val + "->");
            result1 = result1.next;
        }
        System.out.println();

        ListNode result2 = new Merge2SortedLists().mergeTwoLists(null, l2);
        while (result2 != null) {
            System.out.print(result2.val + "->");
            result2 = result2.next;
        }
        System.out.println();

        ListNode result3 = new Merge2SortedLists().mergeTwoLists(l1, null);
        while (result3 != null) {
            System.out.print(result3.val + "->");
            result3 = result3.next;
        }
        System.out.println();

        ListNode result = new Merge2SortedLists().mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println();
    }

}

