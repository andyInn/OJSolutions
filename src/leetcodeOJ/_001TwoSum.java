package leetcodeOJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _001TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int len = numbers.length;
		int[] result = new int[2];
		for (int i = 0; i < len; i++) {
			result[1] = i + 1;
			int last = target - numbers[i];
			if (m.containsKey(last)) {
				result[0] = m.get(last);
				break;
			}
			m.put(numbers[i], i + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		_001TwoSum sl = new _001TwoSum();
		int[] numbers = { 3, 2, 4 };
		int target = 6;
		System.out.println(Arrays.toString(sl.twoSum(numbers, target)));
	}
}