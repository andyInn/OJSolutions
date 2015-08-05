package niuKe_exam;

/**
 * [编程题] 按照左右半区的方式重新组合单链表
给定一个单链表的头部节点head，链表长度为N。 
如果N为偶数，那么前N/2个节点算作左半区，后N/2个节点算作右半区；
 如果N为奇数，那么前N/2个节点算作左半区，后N/2+1个节点算作右半区；
  左半区从左到右依次记为L1->L2->...，右半区从左到右依次记为R1->R2->...。
  请将单链表调整成L1->R1->L2->R2->...的样子。
   例如： 1->2->3->4 调整后：1->3->2->4 
   1->2->3->4->5 调整后：1->3->2->4->5 
   要求：如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 * @author Andy
 *
 */
public class Solution21 {

	public void relocateList(ListNode head) {
		//此答案正确，head即头元素，此处认为没有头结点
		int Listlength = 0;
		ListNode pListNode = head;
		while (pListNode != null) {
			Listlength++;
			pListNode = pListNode.next;
		}
		int half = Listlength / 2;
		ListNode rightnode = head;
		ListNode leftnode = head;
		int i = 0;
		while (i < half - 1) {//如果有5个结点，那么half=2，这里只循环一次
			rightnode = rightnode.next;
			i++;
		}
		i = 0;
		// System.out.println(rightnode.val);
		while (i < half - 1) {//这里直接将右半区的前half-1个'值'插入到左半区对应位置了
			ListNode tmp = new ListNode(rightnode.next.val);
			rightnode.next = rightnode.next.next;//将断掉的链表部分链接起来，如果有5个结点，那么就是2->4
			tmp.next = leftnode.next;
			leftnode.next = tmp;
			leftnode = tmp.next;
			i++;
		}

	}
	
	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		//listNode5.next = listNode6;

		Solution21 solution2 = new Solution21();
		solution2.relocateList(listNode1);
		solution2.print(listNode1);
	}
}
