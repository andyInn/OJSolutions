package leetcodeOJ;

public class _203RemoveLinkedListElements {
    
	public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode p=head,q=null;
        while(p!=null){
        	if(p.val==val){
        		p=p.next;
        		if(q==null) head=p;
        		if(q!=null) q.next=p;
        		continue;
        	}
        	q=p;
        	p=p.next;
        }
        return head;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(6);
//		ListNode list1 = new ListNode(2);
//		ListNode list2 = new ListNode(6);
//		ListNode list3 = new ListNode(3);
//		ListNode list4 = new ListNode(4);
//		ListNode list5 = new ListNode(5);
//		ListNode list6 = new ListNode(6);
//		ListNode list7 = new ListNode(1);
		ListNode li = new ListNode(1);
//		head.next=list1;
//		list1.next=list2;
//		list2.next=list3;
//		list3.next=list4;
//		list4.next=list5;
//		list5.next=list6;
		
		_203RemoveLinkedListElements sl=new _203RemoveLinkedListElements();
		li=sl.removeElements(head, 6);
		while(li!=null){
			System.out.println(li.val);
			li=li.next;
		}
	}

  //Definition for singly-linked list.
  	public static class ListNode {
  		int val;
  		ListNode next;

  		ListNode(int x) {
  			val = x;
  		}
  	}
}