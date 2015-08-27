package leetcodeOJ;

public class _92ReverseLinkedList_II  {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (n == m)
			return head;
		ListNode p = head, left = head, p1 = head, p2 = head;
		int count = 1;
		if (m > 1) {
			while (count++ < m) {// count值不满足此条件后也会做++操作，所以后面需要--操作
				left = p;
				p = p.next;
				p1 = p;
			}
			count--;
		}
		if (m > 1) {
			while (count++ <= n) {
				p2 = p.next;
				p.next = left.next;
				left.next = p;
				p = p2;
			}
		} else {
			while (count++ <= n) {
				p2 = p.next;
				p.next = left;
				left = p;
				p = p2;
			}
			head=left;
		}
		p1.next = p;
		return head;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		int m = 3, n = 4;
		head = reverseBetween(head, m, n);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
