package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _219ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if (i - map.get(nums[i]) <= k)
					return true;
				map.put(nums[i], i);
			}
		}// for
		return false;
	}

	public static void main(String... strings) {
		int[] nums={1,2,3,1};
		System.out.println(containsNearbyDuplicate(nums, 3));
	}
}
