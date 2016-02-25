package leetcodeOJ;

public class _328Odd_Even_Linked_List {
	public static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null)
			return head;
		//p工作指针，q临时指针，tail1/2为前面的两个尾指针
		ListNode p=head.next.next,tail1=head,tail2=head.next,q=p;
		tail2.next=null;
		while(p!=null){
			q=p;
			p=p.next;
			//odd
			q.next=tail1.next;
			tail1.next=q;
			tail1=tail1.next;
			if(p!=null){
				//even
				q=p;
				p=p.next;
				q.next=tail2.next;
				tail2.next=q;
				tail2=tail2.next;
			}
		}//while
        return head;
    }
	
	public static void main(String ...strings){
		ListNode r1=new ListNode(1);
		ListNode r2=new ListNode(2);
		ListNode r3=new ListNode(3);
		ListNode r4=new ListNode(4);
		ListNode r5=new ListNode(5);
		ListNode r6=new ListNode(6);
		ListNode r7=new ListNode(7);
		r1.next=r2;
		r2.next=r3;
		r3.next=r4;
		r4.next=r5;
		r5.next=r6;
		r6.next=r7;
		r7.next=null;
		ListNode head=oddEvenList(r1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
