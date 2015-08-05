package leetcodeOJ;

import java.util.LinkedList;
import java.util.Queue;

public class _116PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if(root==null) return;
		Queue<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
		TreeLinkNode p, lastVisit;
		int index = 1, level = 1, sum = 1;
		q.offer(root);
		while(!q.isEmpty()){
			p=q.poll();//出队
			lastVisit=p;
			if(p.left!=null) q.offer(p.left);
			if(p.right!=null) q.offer(p.right);
			if(index==sum){
				lastVisit.next=null;
				level++;
				sum += (int) Math.pow(2, level - 1);
			}
			else{
				p=q.peek();
				lastVisit.next=p;
			}
			index++;
		}
	}
    public static void main(String[] args){
		TreeLinkNode tree1 = new TreeLinkNode(1);
		TreeLinkNode tree2 = new TreeLinkNode(2);
		TreeLinkNode tree3 = new TreeLinkNode(3);
		TreeLinkNode tree4 = new TreeLinkNode(4);
		TreeLinkNode tree5 = new TreeLinkNode(5);
		TreeLinkNode tree6 = new TreeLinkNode(6);
		TreeLinkNode tree7 = new TreeLinkNode(7);
		tree1.left = tree2; tree1.right = tree3;
		tree2.left = tree4; tree2.right = tree5;
		tree3.left = tree6; tree3.right = tree7;
		_116PopulatingNextRightPointersInEachNode sl = 
				new _116PopulatingNextRightPointersInEachNode();
		TreeLinkNode t=new TreeLinkNode(0);
		sl.connect(tree1);
		t=tree4;
		while(t!=null){
			System.out.println(t.val);
			t=t.next;
		}
    }
    
  //Definition for binary tree
  	public static class TreeLinkNode {
  		int val;
  		TreeLinkNode left, right, next;

  		TreeLinkNode(int x) {
  			val = x;
  		}
  	}
}