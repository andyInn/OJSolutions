package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 1	   ____1____
 * 		  /	  		\
 * 2	 2	   		 3
 * 	 	  \	  	   /   \
 * 3	   4 	  5 	6
 *  	  		 /	  	 \
 * 4	   		7	   	  8
 * 				  		 /
 * 5			 		9
 * NLR: ABDCEGFHI
 * LNR: BDAGECFIH
 * LRN: DBGEIHFCA
 * Level: ABCDEFGHI
 * @param args
 */
public class _144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		List<Integer> li=new ArrayList<Integer>();
		while(p!=null||!s.isEmpty()){
			while(p!=null){
				li.add(p.val);
				s.push(p);
				p=p.left;
			}
			if(!s.isEmpty()){
				p=s.pop();
				p=p.right;
			}
		}//while
		return li;
    }
    public static void main(String[] args){
		TreeNode tree = new TreeNode(1);
		TreeNode treeB = new TreeNode(2);
		TreeNode treeC = new TreeNode(3);
		TreeNode treeD = new TreeNode(4);
		TreeNode treeE = new TreeNode(5);
		TreeNode treeF = new TreeNode(6);
		TreeNode treeG = new TreeNode(7);
		TreeNode treeH = new TreeNode(8);
		TreeNode treeI = new TreeNode(9);
		tree.left = treeB; tree.right = treeC;
		treeB.right = treeD;
		treeC.left = treeE; treeC.right = treeF;
		treeE.left = treeG;
		treeF.right = treeH;
		treeH.left = treeI;
		_144BinaryTreePreorderTraversal sl = new _144BinaryTreePreorderTraversal();
		List<Integer> li = sl.preorderTraversal(tree);
		System.out.println(li.toString());
		//PreOrder:[A, B, D, C, E, G, F, H, I]
    }
    
  //Definition for binary tree
  	public static class TreeNode {
  		int val;
  		TreeNode left;
  		TreeNode right;

  		TreeNode(int x) {
  			val = x;
  		}
  	}
}