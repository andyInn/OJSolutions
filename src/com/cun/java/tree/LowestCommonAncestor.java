package com.cun.java.tree;

import java.util.Stack;

import leetcodeOJ.TreeNode;

public class LowestCommonAncestor {
	/**
	 * 本函数实现了查找两结点最近公共祖先的功能。
	 * 说明：祖先包括自己，输入空树返回null
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        Stack<TreeNode> s3=new Stack<TreeNode>();
        TreeNode n=root,res=root, lastVisit=null;
        boolean f1=false,f2=false;
        while(n!=null||!s1.empty()){
        	while(n!=null){
        		s1.push(n);
        		n=n.left;
        	}
        	if(!s1.empty()){
        		n=s1.peek();
        		if(n.right!=null&&n.right!=lastVisit){
        			n=n.right;
        		}else{
        			n=s1.pop();
        			if(n.val==p.val){
        				f1=true;
        				if(f2==true)
            				break;
        				s2.push(n);
        				while(!s1.empty()){
        					s2.push(s1.peek());
        					s3.push(s1.pop());
        				}
        				while(!s3.empty())
        					s1.push(s3.pop());
        			}
        			if(n.val==q.val){
        				f2=true;
        				if(f1==true)
            				break;
        				s2.push(n);
        				while(!s1.empty()){
        					s2.push(s1.peek());
        					s3.push(s1.pop());
        				}
        				while(!s3.empty())
        					s1.push(s3.pop());
        			}
        			lastVisit=n;
        			n=null;
        		}
        	}
        }//while
        s3.push(n);
        while(!s1.empty()){
			s3.push(s1.pop());
		}
        if(s2.size()<s3.size()){
        	while(!s2.empty()){
            	if(s2.peek()==s3.peek()){
            		res=s2.pop();
            		s3.pop();
            	}else{
            		break;
            	}
            }
        }else {
        	while(!s3.empty()){
            	if(s2.peek()==s3.peek()){
            		res=s2.pop();
            		s3.pop();
            	}else{
            		break;
            	}
            }
		}
        return res;
    }
	
	public static void main(String[] args){
		TreeNode r=new TreeNode(6);
		TreeNode r1=new TreeNode(2);
		TreeNode r2=new TreeNode(8);
		TreeNode r3=new TreeNode(0);
		TreeNode r4=new TreeNode(4);
		TreeNode r5=new TreeNode(7);
		TreeNode r6=new TreeNode(9);
		TreeNode r7=new TreeNode(3);
		TreeNode r8=new TreeNode(5);
		r.left=r1;
		r.right=r2;
		r1.left=r3;
		r1.right=r4;
		r2.left=r5;
		r2.right=r6;
		r3.left=null;
		r3.right=null;
		r4.left=r7;
		r4.right=r8;
		r5.left=null;
		r5.right=null;
		r6.left=null;
		r6.right=null;
		r7.left=null;
		r7.right=null;
		r8.left=null;
		r8.right=null;
		System.out.println(lowestCommonAncestor(r, r3, r6).val);
	}
}
