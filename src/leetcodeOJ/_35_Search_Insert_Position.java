package leetcodeOJ;

public class _35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length<1 ) return 0;
        int start = 0, end = nums.length-1, p=0;
        while(start<=end){
            p = (start+end)/2;
            if(nums[p]==target) return p;
            if(nums[p]<target) {start=p+1; continue;}
            if(nums[p]>target) {end=p-1; continue;}
        }
        return p==start?p:start;
    }
}
