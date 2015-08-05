package leetcodeOJ;

import java.util.Arrays;


public class __201BitwiseANDofNumbersRange {
    //大是大非
	public int rangeBitwiseAnd(int m, int n) {
		int MAX=32;
		boolean first=true;
		int[] a=new int[MAX];
		Arrays.fill(a, 0);
		String sm,sn;
		int lenm=0,lenn=0;
        while(true){
        	sm=Integer.toString(m);
        	sn=Integer.toString(n);
        	lenm=sm.length();
        	lenn=sn.length();
        	if(lenn>lenm&&first==true) return 0;
        	if(lenn>lenm){
        		Arrays.fill(a, MAX-lenn+1, MAX, 0);
        		break;
        	}
        	//lenn<lenm
        	//lenn<lenm
        	//lenn<lenm
        	//lenn<lenm
        	//lenn<lenm
        	//lenn<lenm
        	first=false;
        	a[MAX-lenm+1]=1;
        	if(lenm==1) break;
        	sm=sm.substring(1);
        	sn=sn.substring(1);
        	m=Integer.valueOf(sm);
        	n=Integer.valueOf(sn);
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<32;i++){
        	res.append(a[i]+48);
        }
        return Integer.valueOf(res.toString());
    }
	
	public static void main(String[] args){
		System.out.println(1<<30);
	}

}

/*public static void main(String[] args){
	ListNode head = new ListNode(6);
//	ListNode list1 = new ListNode(2);
//	ListNode list2 = new ListNode(6);
//	ListNode list3 = new ListNode(3);
//	ListNode list4 = new ListNode(4);
//	ListNode list5 = new ListNode(5);
//	ListNode list6 = new ListNode(6);
//	ListNode list7 = new ListNode(1);
	ListNode li = new ListNode(1);
//	head.next=list1;
//	list1.next=list2;
//	list2.next=list3;
//	list3.next=list4;
//	list4.next=list5;
//	list5.next=list6;
	
	Solution sl=new Solution();
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
  	}*/