package leetcodeOJ;

import java.util.HashSet;
import java.util.Set;

public class _217ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (s.contains(nums[i]))
				return true;
			else
				s.add(nums[i]);
		}
		return false;
	}

	public static void main(String... strings) {
//		int[] nums={};
//		int[] nums={1};
//		int[] nums={1,2,3,4};
		int[] nums={1,0};
		System.out.println(containsDuplicate(nums));
	}
}
