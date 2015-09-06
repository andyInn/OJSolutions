package leetcodeOJ;

public class _153FindMinimumInRotatedSortedArray {
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums[0] <= nums[nums.length - 1])
			return nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > min)
				continue;
			min = nums[i];
			break;
		}
		return min;
	}
	
	public static int findMin2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums[0] <= nums[nums.length - 1])
			return nums[0];
		int left=0,right=nums.length-1;
		while(left<right){
			if(nums[left+1]>nums[left])left++;
			else return nums[left+1];
			if(nums[right-1]<nums[right])right--;
			else return nums[right];
		}
		return nums[right];
	}

	public static void main(String... strings) {
		int[] nums={4,5,6,7,1,2,3};
		System.out.println(findMin2(nums));
	}
}
