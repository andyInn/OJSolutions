package leetcodeOJ;

import java.util.TreeSet;

public class _220ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0)
			return false;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (set.floor(n) != null && n <= t + set.floor(n)
					|| set.ceiling(n) != null && set.ceiling(n) <= t + n)
				return true;
			set.add(n);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}
	
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0)
			return false;
		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.subSet((long) nums[i] - t, (long) nums[i] + t + 1).isEmpty())
				return true;
			set.add((long) nums[i]);
			if (i >= k)
				set.remove((long) nums[i - k]);
		}
		return false;
	}

	public static void main(String... strings) {
		int[] nums = { -1, -1 };//[0,2147483647], 1, 2147483647
		System.out.println(containsNearbyAlmostDuplicate2(nums, 1, 0));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
	}
}
