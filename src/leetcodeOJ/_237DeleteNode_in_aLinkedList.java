package leetcodeOJ;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _237DeleteNode_in_aLinkedList {
    public void deleteNode(ListNode node) {
        if(node==null){
        	return;
        }
        ListNode pre=node;
        ListNode pt=node.next;
        pre.val=pt.val;
        pre.next=pt.next;
        pt=null;
    }
    //Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}