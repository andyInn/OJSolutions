package alibaba;

import java.util.Stack;

import leetcodeOJ.TreeNode;

public class MaxValueInTree {
	
	public static int maxValueInTree(TreeNode r){
		if(r==null)
			return -1;
		if(r.left==null&&r.right==null)
			return 0;
		int min=r.val,max=r.val;
		Stack<TreeNode> s=new Stack<TreeNode>();
		TreeNode p=r;
		while(p!=null||!s.empty()){//NLR
			while(p.left!=null){
				if(p.val<min){
					min=p.val;
				}
				if(p.val>min){
					max=p.val;
				}
				s.push(p);
				p=p.left;
			}
			if(!s.empty()){
				p=s.pop();
				p=p.right;
			}
		}
		return max-min;
	}

	public static void main(String[] args){
		
	}
}
