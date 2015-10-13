package com.beijing.chuangxingongchang;
/*2.将链表中的所有元素为奇数的节点移到元素为偶数节点的前面，并保证奇数之间顺序不变，偶数之间顺序不变。

示例：
交换前链表的顺序		交换后链表的顺序
4→5→3→1→2   ==>  5→3→1→4→2 
1 ==> 1			（链表仅含一个元素)
2→1 ==>1→2  
	==>		(链表为空)

C/C++:
链表节点定义为：
struct node {
struct node *next;
int value;
};
struct node *swap(struct node *list);
Java:
链表节点定义为：
class Node {
public Node next;
public int value
}
Node swap(Node list)

注意点和要求如下:
1. swap函数要求对节点的指针/引用进行操作（不得创建任何新的链表节点）
2. 不得使用任何库函数/API，如需使用类似功能, 请自行实现
3. 不得将链表转化为其他类型数据结构再进行交换，如数组等
*/
public class _2 {
	/**
	 * 时间复杂度O(n),空间复杂度O(1)
	 * @param list
	 * @return
	 */
	public static Node swap(Node list) {
		if (list == null || list.next == null)//链表为null或只有一个结点，直接返回
			return list;
		Node p = list, tmp = null;//定义工作指针p和临时指针tmp
		list = null;
		//left为奇数值结点的工作指针,right为偶数值结点的工作指针,headRight为偶数值结点的头指针
		Node left = list, right = list, headRight = list;
		while (p != null) {
			tmp = p.next;//暂存工作指针的下一个结点
			if ((p.value & 1) == 1) {// 元素为奇数
				if(left==null){//只执行一次
					p.next = left;//在奇数链表末尾插入新奇数结点
					left = p;
					list = left;//更新奇数值结点的头指针
				}else {
					p.next = left.next;//在奇数链表末尾插入新奇数结点
					left.next = p;
					left =left.next;//更新到最后一个非空结点
				}
			} else {
				if(right==null){//只执行一次
					p.next = right;//在偶数链表末尾插入新偶数结点
					right = p;
					headRight = right;//更新偶数值结点的头指针
				}else{
					p.next = right.next;//在偶数链表末尾插入新偶数结点
					right.next = p;
					right=right.next;//更新到最后一个非空结点
				}
			}
			p = tmp;//更新工作指针
		}
		if (list == null)//没有奇数值结点
			list = headRight;
		else//将奇数链表接在偶数链表末尾
			left.next = headRight;
		return list;
	}

	public static void main(String[] args) {
		Node list = new Node();
		Node list2 = new Node();
		Node list3 = new Node();
		Node list4 = new Node();
		Node list5 = new Node();
		Node list6 = new Node();
		list.value = 0;
		list.next = list2;
		list2.value = 1;
		list2.next = list3;
		list3.value = 3;
		list3.next = list4;
		list4.value = 4;
		list4.next = list5;
		list5.value = 5;
		list5.next = list6;
		list6.value = 6;
		list6.next = null;
		Node h = swap(list);
		while (h != null) {
			System.out.print(h.value + " ");
			h = h.next;
		}
	}
}

class Node {
	public Node next;
	public int value;
}
