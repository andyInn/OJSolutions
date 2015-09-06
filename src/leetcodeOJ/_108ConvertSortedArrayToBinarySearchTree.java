package leetcodeOJ;

import java.util.Arrays;

public class _108ConvertSortedArrayToBinarySearchTree {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		if (nums.length == 1) {
			TreeNode head = new TreeNode(nums[0]);
			head.left = null;
			head.right = null;
			return head;
		}
		int mid = (nums.length - 1) >> 1;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		head.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
		return head;
	}
	
	public static void inOrder(TreeNode root) {
		if(root==null)  return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static void main(String... strings) {
		int[] nums={1,2,3};
		inOrder(sortedArrayToBST(nums));
	}
}
