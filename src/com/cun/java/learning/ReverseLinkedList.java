package com.cun.java.learning;

public class ReverseLinkedList {
	class LNode{
		public LNode(int data){
			this.data=data;
			this.next=null;
		}
		public int data;
		public LNode next;
	}

	/**
	 * 没有头结点的单链表逆置
	 * @param N
	 */
	public static LNode reverse(LNode N){
		if(N==null)//单链表为空，不进行逆置操作
			return null;
		if(N.next==null)//单链表只有一个元素，不进行逆置操作
			return N;
		LNode p=N.next,q=p.next;//令p指向线性表中的第2个元素
		N.next=null;//摘掉第二个元素及其后面的所有元素
		while(p!=null){
			q=p.next;//暂存p后面的元素，防止单链表断裂
			p.next=N;
			N=p;
			p=q;//继续访问下一个元素
		}
		return N;
	}
	
/*	public static void reverse2(LNode N){
		if(N==null||N.next==null)//单链表为空或单链表只有一个元素，不进行逆置操作
			return ;
		LNode p=N.next,q=p.next;//令p指向线性表中的第2个元素
		N.next=null;//摘掉第二个元素及其后面的所有元素
		while(p!=null){
			q=p.next;//暂存p后面的元素，防止单链表断裂
			p.next=N;
			N=p;
			p=q;//继续访问下一个元素
		}
//		LNode pp = N;
//		while (pp != null) {
//			System.out.println(pp.data);
//			pp = pp.next;
//		}
	}*/
	
	public static void main(String[] args){
		ReverseLinkedList rll=new ReverseLinkedList();
		LNode n=rll.new LNode(0);
		LNode n1=rll.new LNode(1);
		LNode n2=rll.new LNode(2);
		LNode n3=rll.new LNode(3);
		n.next=n1;
		n1.next=n2;
		n2.next=n3;
		LNode p=reverse(n);
//		reverse2(n);
//		LNode p = n;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
}
