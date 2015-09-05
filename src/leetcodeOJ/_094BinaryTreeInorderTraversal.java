package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094BinaryTreeInorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> li = new ArrayList<Integer>();
		if (root == null) {
			li.clear();
			return li;
		}
		if (root.left == null && root.right == null) {
			li.add(root.val);
			return li;
		}
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.left;
			}
			if (!s.isEmpty()) {
				p = s.pop();
				li.add(p.val);
				p = p.right;
			}
		}
		return li;
	}

	public static void main(String... strings) {
		TreeNode root = new TreeNode(0);
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(5);
		TreeNode p6 = new TreeNode(6);
		TreeNode p7 = new TreeNode(7);
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		p2.right = p6;
		p3.left = null;
		p3.right = null;
		p4.left = null;
		p4.right = null;
		p5.left = null;
		p5.right = null;
		p6.left = p7;
		p6.right = null;
		p7.left = null;
		p7.right = null;
		for (Integer i : inorderTraversal(p7)) {
			System.out.print(i + " ");
		}
	}
}
