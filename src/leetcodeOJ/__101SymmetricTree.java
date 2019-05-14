package leetcodeOJ;

public class __101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(null==root) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(null==left&&null==right) return true;
        if(null==left || null==right || left.val!=right.val) return false;
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
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
