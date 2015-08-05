package com.cun.java.tree;

//Definition for binary tree
public class TreeNode<T> {
	T val;
	TreeNode<T> left;
	TreeNode<T> right;

	TreeNode() {
		this.val = null;
		this.left = null;
		this.right = null;
	}

	TreeNode(T x) {
		this.val = x;
		this.left = null;
		this.right = null;
	}
	
	TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
		this.val = x;
		this.left = left;
		this.right = right;
	}
}
