package com.cun.java.tree;

import java.util.Vector;
//无需解释，递归最简洁，最容易理解过程
public class RecursiveTraversal {
	public <T> void PreOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		path.add((T) root.val);
		PreOrder(root.left, path);
		PreOrder(root.right, path);
	}

	public <T> void InOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		InOrder(root.left, path);
		path.add((T) root.val);
		InOrder(root.right, path);
	}

	public <T> void PostOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null)  return;
		PostOrder(root.left, path);
		PostOrder(root.right, path);
		path.add((T) root.val);
	}
}
