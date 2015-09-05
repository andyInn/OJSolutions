package com.cun.java.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TestBinaryTree {

	/**
	 * 1	   ____A____
	 * 		  /	  		\
	 * 2	 B	   		 C
	 * 	 	  \	  	   /   \
	 * 3	   D 	  E 	F
	 *  	  		 /	  	 \
	 * 4	   		G	   	  H
	 * 				  		 /
	 * 5			 		I
	 * NLR: ABDCEGFHI
	 * LNR: BDAGECFIH
	 * LRN: DBGEIHFCA
	 * Level: ABCDEFGHI
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode<Character> tree = new TreeNode<Character>('A');
		TreeNode<Character> treeB = new TreeNode<Character>('B');
		TreeNode<Character> treeC = new TreeNode<Character>('C');
		TreeNode<Character> treeD = new TreeNode<Character>('D');
		TreeNode<Character> treeE = new TreeNode<Character>('E');
		TreeNode<Character> treeF = new TreeNode<Character>('F');
		TreeNode<Character> treeG = new TreeNode<Character>('G');
		TreeNode<Character> treeH = new TreeNode<Character>('H');
		TreeNode<Character> treeI = new TreeNode<Character>('I');
		tree.left = treeB; tree.right = treeC;
		treeB.right = treeD;
		treeC.left = treeE; treeC.right = treeF;
		treeE.left = treeG;
		treeF.right = treeH;
		treeH.left = treeI;
		
		Vector<Character> path = new Vector<Character>();
		RecursiveTraversal rt = new RecursiveTraversal();
		rt.preOrder(tree, path); System.out.println("RecursiveTraversal PreOrder:"+path); path.clear();
		rt.inOrder(tree, path); System.out.println("RecursiveTraversal InOrder:"+path); path.clear();
		rt.postOrder(tree, path); System.out.println("RecursiveTraversal PostOrder:"+path); path.clear();
		
		NonrecursiveTraversal nrt = new NonrecursiveTraversal();
		nrt.PreOrder(tree, path); System.out.println("NonrecursiveTraversal PreOrder:"+path); path.clear();
		nrt.InOrder(tree, path); System.out.println("NonrecursiveTraversal InOrder:"+path); path.clear();
		nrt.PostOrder(tree, path); System.out.println("NonrecursiveTraversal PostOrder:"+path); path.clear();
		nrt.LevelOrder(tree, path); System.out.println("NonrecursiveTraversal LevelOrder:"+path); path.clear();
		
		List<Character> preOrderList = new ArrayList<Character>(Arrays.asList('A', 'B', 'D', 'C', 'E', 'G', 'F', 'H', 'I'));
		List<Character> inOrderList = new ArrayList<Character>(Arrays.asList('B', 'D', 'A', 'G', 'E', 'C', 'F', 'I', 'H'));
		TreeNode<Character> root = null;
		root = nrt.BuildBinaryTree(preOrderList, inOrderList, root);
		nrt.LevelOrder(root, path); System.err.println("NonrecursiveTraversal LevelOrder:"+path); path.clear();
	}
}
