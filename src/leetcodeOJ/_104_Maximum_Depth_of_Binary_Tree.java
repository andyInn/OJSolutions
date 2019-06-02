package leetcodeOJ;

public class _104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left) return maxDepth(root.right) + 1;
        if (null == root.right) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
