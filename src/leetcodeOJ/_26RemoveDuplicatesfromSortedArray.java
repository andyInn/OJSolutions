package leetcodeOJ;

public class _26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (null == nums) return 0;
        if (nums.length < 2) return nums.length;
        int p1 = 0, p2 = 1;
        for (; p2 < nums.length; p2++) {
            if (nums[p1] == nums[p2]) continue;
            nums[++p1] = nums[p2];
        }
        return p1 + 1;
    }
}
