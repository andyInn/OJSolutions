package leetcodeOJ;

import java.util.LinkedList;
import java.util.Queue;

public class _226InvertBinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		TreeNode p1=invertTree(root.left);
		root.left=invertTree(root.right);
		root.right=p1;
		return root;
	}
	
	public static TreeNode invertTree2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode p = q.poll();
			if (p == null)
				break;
			if (p.left != null)
				q.offer(p.left);
			if (p.right != null)
				q.offer(p.right);
			TreeNode p1 = p.left;
			p.left = p.right;
			p.right = p1;
		}
		return root;
	}
	
	public static void preOrder(TreeNode root) {
		if(root==null)  return;
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String... strings) {
		TreeNode root=new TreeNode(0);
		TreeNode p1=new TreeNode(1);
		TreeNode p2=new TreeNode(2);
		TreeNode p3=new TreeNode(3);
		TreeNode p4=new TreeNode(4);
		TreeNode p5=new TreeNode(5);
		TreeNode p6=new TreeNode(6);
		TreeNode p7=new TreeNode(7);
		root.left=p1;
		root.right=p2;
		p1.left=p3;
		p1.right=p4;
		p2.left=p5;
		p2.right=p6;
		p3.left=null;
		p3.right=null;
		p4.left=null;
		p4.right=null;
		p5.left=null;
		p5.right=null;
		p6.left=p7;
		p6.right=null;
		p7.left=null;
		p7.right=null;
		preOrder(invertTree2(null));
	}
}
