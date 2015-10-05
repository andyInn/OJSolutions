package leetcodeOJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167, Two Sum II - Input array is sorted
 * 
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * 典型的双指针问题。
 * 
 * 初始化左指针left指向数组起始，初始化右指针right指向数组结尾。
 * 
 * 根据已排序这个特性，
 * 
 * （1）如果numbers[left]与numbers[right]的和tmp小于target，说明应该增加tmp,因此left右移指向一个较大的值。
 * 
 * （2）如果tmp大于target，说明应该减小tmp,因此right左移指向一个较小的值。
 * 
 * （3）tmp等于target，则找到，返回left+1和right+1。（注意以1为起始下标）
 * 
 * 时间复杂度O(n): 扫一遍
 * 
 * 空间复杂度O(1)
 * 
 * ps: 严格来说，两个int的加和可能溢出int，因此将tmp和target提升为long long int再进行比较更鲁棒。
 * 
 * @author Andy
 * 
 */
public class _167TwoSumII {
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		_167TwoSumII sl = new _167TwoSumII();
		int[] re = sl.twoSum2(numbers, target);
		System.out.println(Arrays.toString(re));
	}

	/**
	 * 算法没有问题，考虑问题要有正确的方法，首先要读"懂"题意，高清边界条件和约束条件。
	 * 此题目题目明确了只有一对符合要求的值存在，并且一定存在，不存在找不到正确解的情况。
	 * 这里假设数组中存在两个符合要求的值，那么从两边向中间靠拢就一定可以找到他们～
	 * 可以自己验证，不存在工作指针跑到两个数中间去的情况，因为结果只有一个，
	 * 退一步说如果存在在这之前就已经找到就会保存正确结果并返回了。
	 * 时间复杂度O(n)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers[0] > (target >> 2)) return null;
		int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;
		while (numbers[right] > target) right--;
		while (left < right) {
			int tmp = target - numbers[right];
			int ans=0;
			if (tmp == numbers[left]) {		//即两数和等于于target
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else//即两数和小于target时left++,两数和大于target时right--
				ans = tmp > numbers[left] ? left++ : right--;
		}
		return result;
	}
	
	/**
	 * 这个方法可以通过，不会LTE。时间复杂度O(n)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int[] ans = new int[2];
		int low = 0, temp = 0;
		Map<Integer, Integer> re = new HashMap<Integer, Integer>();
		for (int high = 0; high < numbers.length; high++) {
			if(!re.containsKey(numbers[high])) re.put(numbers[high], high);
			if(re.containsKey(temp = target - numbers[high])){
				low = re.get(temp);
				ans[0] = low + 1;
				ans[1] = high + 1;
				break;
			}
		}
		return ans;	
	}
}
