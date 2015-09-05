package leetcodeOJ;

public class _035SearchInsertPosition {
	public static int binarySearch(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				low = mid + 1;
			if (nums[mid] > target)
				high = mid - 1;
		}
		return low;
	}
	
	public static int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		return binarySearch(nums, target);
	}

	public static void main(String... strings) {
		int[] nums={2,4,5,6};
		System.out.println(searchInsert(nums, -999));
	}
}
