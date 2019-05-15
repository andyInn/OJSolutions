package leetcodeOJ;

public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(null==nums||nums.length<1) return 0;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>=0){
                nums[i] += nums[i-1];
            }
            max = nums[i]>max?nums[i]:max;
        }
        return max;
    }
}
