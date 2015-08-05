package com.cun.java.tree;

import java.util.ArrayList;

public class Solution {
    public int maxDepth(TreeNode root) {
        //递归
    	int depth = 0;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	al.clear();
    	if(root!=null){
    		depth++;
    		int l, r;
    		depth += (l = maxDepth(root.left)) > (r = maxDepth(root.right)) ? l : r;
    	}
    	return depth;
    }
}