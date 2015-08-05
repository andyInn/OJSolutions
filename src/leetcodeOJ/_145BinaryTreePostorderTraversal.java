package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if(root == null){
        	list.clear();
        	return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p=root, lastVist =null;
        while(p!=null||!stack.empty()){
        	while(p!=null){
        		stack.push(p);
        		p=p.left;
        	}
        	if(!stack.empty()){
        		p=stack.peek();
        		if(p.right!=null&&p.right!=lastVist){
        			p=p.right;
        		}else{
        			p=stack.pop();
        			list.add(p.val);
        			lastVist=p;
        			p=null;
        		}
        	}
        }//while
        return list;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}