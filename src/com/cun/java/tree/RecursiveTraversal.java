package com.cun.java.tree;

import java.util.Vector;
//无需解释，递归最简洁，最容易理解过程
public class RecursiveTraversal {
	public <T> void preOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		path.add((T) root.val);
		preOrder(root.left, path);
		preOrder(root.right, path);
	}

	public <T> void inOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		inOrder(root.left, path);
		path.add((T) root.val);
		inOrder(root.right, path);
	}

	public <T> void postOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		postOrder(root.left, path);
		postOrder(root.right, path);
		path.add((T) root.val);
	}
}
