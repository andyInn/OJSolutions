package leetcodeOJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _169MajorityElement {
	public static int majorityElement(int[] nums) {
        int res=0,max=0;
        Map.Entry<Integer, Integer> tmp=null;
        Map<Integer, Integer> tm=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if(!tm.containsKey(nums[i])){
				tm.put(nums[i], 1);
			}else{
				tm.put(nums[i], tm.get(nums[i])+1);
			}
		}
        Iterator<Map.Entry<Integer, Integer>> it=tm.entrySet().iterator();
        while(it.hasNext()){
        	tmp=it.next();
        	if(tmp.getValue()>max){
        		max=tmp.getValue();
        		res=tmp.getKey();
        	}
        }
        return res;
    }
	
	public static void main(String[] args){
		int[] nums={1};
		System.out.println(majorityElement(nums));
	}
}
