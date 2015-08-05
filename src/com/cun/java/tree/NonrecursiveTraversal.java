package com.cun.java.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
//先序和中序都容易理解，关键是后序
//顺便说一句，删除一棵二叉树，即释放一棵二叉树的内存，用后序遍历即可实现（这里的"访问"变成了delete 结点）。  
public class NonrecursiveTraversal {
	public <T> void PreOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null) { path.clear(); return; }
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> p = root;
		while (p != null || !s.empty()) {
			while (p != null) {					//走到最左边
				path.add((T) p.val);
				s.push(p);
				p = p.left;
			}
			if (!s.empty()) {
				p = s.pop();
				p = p.right;
			}
		}//while
	}

	public <T> void InOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null) { path.clear(); return; }
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> p = root;
		while (p != null || !s.empty()) {
			while (p != null) {					//走到最左边
				s.push(p);
				p = p.left;
			}
			if (!s.empty()) {
				p = s.pop();
				path.add((T) p.val);
				p = p.right;
			}
		}
	}

	/**
	 * 因为后序非递归遍历二叉树的顺序是先访问左子树，再访问右子树，最后访问根节点。
	 * ！！！当用堆栈来存储节点，必须分清返回根节点时，是从左子树返回的，还是从右子树返回的。
	 * 所以，一、使用辅助指针r，其指向最近访问过的节点。
	 * 二、也可以在节点中增加一个标志域，记录是否已被访问。（一般不要改节点定义，故法二面试不是最好的选择）。
	 * Tips:也有人另做一个结构体，完成法二，还是增加了空间复杂度，如果只有一个函数体能写代码，则面试绝不能使用法二。
	 * @param root 即根节点
	 * @param path 记录访问过的节点数据值
	 */
	public <T> void PostOrder(TreeNode<T> root, Vector<T> path) {
		if(root==null) { path.clear(); return; }
		Stack<TreeNode<T>> s= new Stack<TreeNode<T>>();
	    TreeNode<T> p = root, lastVisit=null;
	    while(p != null || !s.empty()){
	        while(p != null){ 					//沿左子树一直往下搜索，直至出现没有左子树的结点为止，即走到最左边
				s.push(p);
				p = p.left;
			}
	        if(!s.empty()){
	            p = s.peek();					//取栈顶节点，但不出栈
	            if(p.right!=null&&p.right!=lastVisit){  //如果右子树存在，且未被访问过
	                p = p.right;				//转向右，后续会继续入栈和走到最左，上一个while循环可以完成之
	            }else{  						//否则，弹出节点并访问之
	            	p = s.pop();				//这一句代码前中后序都一样，只为代码一致，便于记忆，其实前序和后序遍历可以不赋值的，只保留s.pop()
	            	path.add((T) p.val);		//访问当前根节点
					lastVisit = p;				//记录最近访问过的节点
	                p = null;					//节点访问完后，重置p指针，避免再次访问出错
	            }
	        }//if
	    }//while
	}
	
	/**
	 * 在层次遍历算法中，加入一个栈，可很容易地将算法改成从下到上、从右到左的遍历二叉树~
	 * @param root
	 * @param path
	 */
	public <T> void LevelOrder(TreeNode<T> root, Vector<T> path){
		if(root==null) { path.clear(); return; }
		Queue<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
		TreeNode<T> p;
		q.offer(root);							//根节点入队
		while(!q.isEmpty()){
			p = q.poll();						//出队
			path.add((T) p.val);				//访问当前根节点
			if(p.left!=null) q.offer(p.left);	//左孩子入队
			if(p.right!=null) q.offer(p.right);	//右孩子入队
		}//while
	}
	
	/**
	 * 本无注释版本有利于面试直接应用！
	 * @param list1
	 * @param list2
	 * @param root
	 * @return
	 */
	public <T> TreeNode<Character> _BuildBinaryTree(List<Character> list1, List<Character> list2, TreeNode<Character> root) {
		//这里只举例通过前序和中序序列来构造出原树root，中序和后序来建立二叉树完全一样，改下后序序列的顺序，就可以应用本算法了，就是找root嘛～
		if(list1.isEmpty()||list2.isEmpty()) return null;
		int len1=list1.size(),len2=list2.size(),curIndex1=0,curIndex2=0;
		char ch=list1.get(curIndex1);
		curIndex2 = list2.indexOf(ch);
		while (curIndex2 == -1 && curIndex1 < len1) //一定能找到list2结点序列所表示子树的根～
			curIndex2 = list2.indexOf(ch = list1.get(++curIndex1));
		root = new TreeNode<Character>(ch);
		root.left = BuildBinaryTree(list1.subList(curIndex1 + 1, len1), list2.subList(0, curIndex2), root.left);
		root.right = BuildBinaryTree(list1.subList(curIndex1 + 1, len1), list2.subList(curIndex2+1, len2), root.right);
		return root;
	}
	
	/**
	 * 本算法建立二叉树为注释版本，可以很清楚的看到建立二叉树的过程
	 * 无注释版本有利于面试直接应用！
	 * @param list1
	 * @param list2
	 * @param root
	 * @return
	 */
	public <T> TreeNode<Character> BuildBinaryTree(List<Character> list1, List<Character> list2, TreeNode<Character> root) {
		//这里只举例通过前序和中序序列来构造出原树root，中序和后序来建立二叉树完全一样，改下后序序列的顺序，就可以应用本算法了，就是找root嘛～
		if(list1.isEmpty()||list2.isEmpty()) return null;
		int len1=list1.size(),len2=list2.size(),curIndex1=0,curIndex2=0;
		System.err.println(list1);
		System.err.println(list2);
		char ch=list1.get(curIndex1);
		curIndex2 = list2.indexOf(ch);
		while (curIndex2 == -1 && curIndex1 < len1)//一定能找到list2结点序列所表示子树的根～
			curIndex2 = list2.indexOf(ch = list1.get(++curIndex1));
		root = new TreeNode<Character>(ch);
		System.out.println("当前根节点是："+root.val);
		System.out.println("left");
		root.left = BuildBinaryTree(list1.subList(curIndex1 + 1, len1), list2.subList(0, curIndex2), root.left);
		if(root.left != null) System.out.println(root.val+"的左孩子是："+root.left.val);
		else System.out.println(root.val+"的左孩子是：null");
		System.out.println("right");
		root.right = BuildBinaryTree(list1.subList(curIndex1 + 1, len1), list2.subList(curIndex2+1, len2), root.right);
		if(root.right != null) System.out.println(root.val+"的右孩子是："+root.right.val);
		else System.out.println(root.val+"的右孩子是：null");
		return root;
	}
}
