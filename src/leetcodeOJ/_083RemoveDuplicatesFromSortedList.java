package leetcodeOJ;

public class _083RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode left = head, p = head.next;
		while (p != null) {
			while (p != null && p.val == left.val)
				p = p.next;
			left.next = p;
			left = p;
			if (p != null) {
				p = p.next;
			}
		}
		return head;
	}

	public static void main(String... strings) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode pp=deleteDuplicates(head);
		while(pp!=null){
			System.out.printf("%d ",pp.val);
			pp=pp.next;
		}
	}
}