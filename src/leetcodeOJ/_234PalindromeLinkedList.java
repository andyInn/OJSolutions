package leetcodeOJ;

public class _234PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		boolean res = true;
		int len = 0, half = 0;
		ListNode p = head, tmp = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		half = (len >> 1);
		p = head;
		head = null;
		for (int i = 0; i < half; i++) {
			tmp = p;
			p = p.next;
			tmp.next = head;
			head = tmp;
		}
		if ((len & 1) == 1)
			p = p.next;
		while (p != null) {
			if (head.val != p.val) {
				res = false;
				break;
			}
			head = head.next;
			p = p.next;
		}
		return res;
	}

	public static void main(String... strings) {
		ListNode head = new ListNode(0);
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(1);
		ListNode p4 = new ListNode(0);
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		System.out.println(isPalindrome(head));
	}
}
