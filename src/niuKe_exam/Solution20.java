package niuKe_exam;

/**
 * [编程题] 按照左右半区的方式重新组合单链表 给定一个单链表的头部节点head，链表长度为N。
 * 如果N为偶数，那么前N/2个节点算作左半区，后N/2个节点算作右半区； 如果N为奇数，那么前N/2个节点算作左半区，后N/2+1个节点算作右半区；
 * 左半区从左到右依次记为L1->L2->...，右半区从左到右依次记为R1->R2->...。
 * 请将单链表调整成L1->R1->L2->R2->...的样子。 例如： 1->2->3->4 调整后：1->3->2->4 1->2->3->4->5
 * 调整后：1->3->2->4->5 要求：如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 * 
 * @author Andy
 * 
 */
public class Solution20 {

	public void relocateList(ListNode head) {// 没有头结点,符合网站预期
		ListNode p1= head;
		ListNode p2= head;
		ListNode pre = null;
		ListNode pTemp = null;

		// 单链表为空或有3个元素以内（少于4个），直接返回此单链表即可
		if (head == null || head.next == null || head.next.next == null || head.next.next.next == null)
			return;

		int length = 0, start2 = 0;
		// 取得单链表长度
		while (p2 != null) {
			length++;
			p2 = p2.next;
		}// while(p2!=null)
		start2 = length / 2;
		p2 = head;
		while (start2 > 0) {
			pre = p2;// 保存左半区最后一个结点
			p2 = p2.next;
			start2--;
		}// while(start2>0)

		pre.next = null;
		// 合并左右半区
		start2 = length / 2;
		while (start2 > 0) {
			// 左半区操作不用另考虑，右半区的结点插入过来即可
			pre = p1;// 插入结点时要用到pre
			p1 = p1.next;

			// 处理右半区结点，头插法
			pTemp = p2;
			p2 = p2.next;
			pTemp.next = p1;
			pre.next = pTemp;

			start2--;
		}// while(start2>0)
		if (p2 != null) {
			pTemp.next = p2;
		}// if(p2!=null)
	}

	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);

		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		// head.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
//		listNode5.next = listNode6;

		Solution20 solution20 = new Solution20();
		solution20.relocateList(listNode1);
		solution20.print(listNode1);
	}
}
