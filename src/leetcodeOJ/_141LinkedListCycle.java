package leetcodeOJ;
public class _141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode p1=head,p2=head;
		while(true){
			if(p1==null) return false;
			p1=p1.next;//p1工作指针每次走一步
			if(p2==null) return false;
			p2=p2.next;//p1工作指针每次走两步，有环肯定能追上p1
			if(p2==null) return false;
			p2=p2.next;
			if(p1==p2) return true;
		}
	}

	/**
	 * Definition for singly-linked list.
	 * @author Andy
	 *
	 */
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}