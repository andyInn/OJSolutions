package leetcodeOJ;

import java.util.Arrays;

public class _238Product_of_ArrayExceptSelf  {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length, left = 1;
		if (len == 2) {
			nums[0] = nums[0] ^ nums[1];
			nums[1] = nums[0] ^ nums[1];
			nums[0] = nums[0] ^ nums[1];
			return nums;
		}
		int[] res = new int[len];
		Arrays.fill(res, 1);
		for (int i = 1; i < len; i++) {
			res[len - i - 1] = nums[len - i] * res[len - i];
		}
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				left = 1;
			} else {
				left *= nums[i - 1];
			}
			res[i] *= left;
		}
		return res;
	}
    
    public static void main(String[] args){
    	_238Product_of_ArrayExceptSelf o=new _238Product_of_ArrayExceptSelf();
    	int[] nums={1,2};
    	System.out.println(Arrays.toString(o.productExceptSelf(nums)));
    }
}