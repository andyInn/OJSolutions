package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _257BinaryTreePaths {
	//Definition for binary tree
	class TreeNode {
		public char val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(char x) {
			val = x;
		}
	}
	
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null) {
			list.clear();
			return list;
		}
		if (root.left == null && root.right == null) {
			list.add(String.valueOf(root.val));
			return list;
		}
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode p = root, lastVist = null;
		while (p != null || !stack.empty()) {// LRN
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.empty()) {
				p = stack.peek();
				if (p.right != null && lastVist != p.right) {
					p = p.right;
				} else {
					p = stack.pop();
					// visit
					if (p.left == null && p.right == null) {
						sb.delete(0, sb.length());
						while (!stack.empty()) {
							stack2.push(stack.pop());
						}
						while (!stack2.empty()) {
							if (sb.length() > 0) {
								sb.append("->");
							}
							sb.append(stack2.peek().val);
							stack.push(stack2.pop());
						}
						sb.append("->" + p.val);
						list.add(sb.toString());
					}
					lastVist = p;
					p = null;
				}
			}
		}
		return list;
	}
	
	public static void main(String ... strings){
		_257BinaryTreePaths o=new _257BinaryTreePaths();
		TreeNode root=o.new TreeNode('A');
		TreeNode t1=o.new TreeNode('B');
		TreeNode t2=o.new TreeNode('C');
		TreeNode t3=o.new TreeNode('D');
		TreeNode t4=o.new TreeNode('E');
		TreeNode t5=o.new TreeNode('F');
		root.left=t1;
		root.right=t2;
		t1.left=t3;
		t2.right=t4;
		t4.left=t5;
		List<String> list=binaryTreePaths(root);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
