package leetcodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums==null||nums.length==0){
    		return new int[0];
    	}
    	int max=nums[0];
    	List<Integer> list=new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++){
    		max=nums[i];
			for (int j = i; (j < i + k && j < nums.length); j++) {
    			if(max<nums[j]){
    				max=nums[j];
    			}
    		}
			if (i + k > nums.length) {
				break;
			}
    		list.add(max);
    	}
    	Integer[] arr=(Integer[])list.toArray(new Integer[list.size()]);
    	int[] arrInt=new int[arr.length];
    	for (int j = 0; j < arr.length; j++) {
    		arrInt[j]=arr[j];
		}
    	return arrInt;
    }//maxSlidingWindow
    
	
	/*public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||nums.length==0){
    		return new int[0];
    	}
		List<Integer> list=new ArrayList<Integer>();
		Queue<Integer> q=new PriorityQueue<Integer>(11, new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						int res = 0;
						if (a < b) {
							res = 1;
						}
						if (a == b) {
							res = 0;
						}
						if (a > b) {
							res = -1;
						}
						return res;
					}
		});
		for (int i = 0; i < nums.length; i++) {
			if(i<k){
				q.offer(nums[i]);
			}else{
				list.add(q.poll());
				q.offer(nums[i]);
			}
		}
		list.add(q.poll());
		Integer[] arr=(Integer[])list.toArray(new Integer[list.size()]);
    	int[] arrInt=new int[arr.length];
    	for (int j = 0; j < arr.length; j++) {
    		arrInt[j]=arr[j];
		}
    	return arrInt;
	}//maxSlidingWindow
*/	
    public static void main(String[] args){
    	int[] nums={1,3,-1,-3,5,3,6,7};
    	_239SlidingWindowMaximum o=new _239SlidingWindowMaximum();
    	System.out.println(Arrays.toString(o.maxSlidingWindow(nums, 3)));
    }
}