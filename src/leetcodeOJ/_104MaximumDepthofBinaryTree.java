package leetcodeOJ;

public class _104MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        //递归
    	int depth = 0;
    	if(root!=null){
    		depth++;
    		int l, r;
    		depth += (l = maxDepth(root.left)) > (r = maxDepth(root.right)) ? l : r;
    	}
    	return depth;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
