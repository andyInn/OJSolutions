package leetcodeOJ;

public class _191Number_of_1_Bits {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		_191Number_of_1_Bits sl = new _191Number_of_1_Bits();
		System.out.println(sl.hammingWeight(1));
		System.out.println(sl.hammingWeight(7));
		System.out.println(sl.hammingWeight(8));
		long endTime = System.currentTimeMillis();
		System.out.printf("Runtime is:%d ms", endTime - startTime);
	}

	public int hammingWeight(int n) {
		int sum = 0, i = 0, temp = 0;
		while (i < 32) {
			int bit = n & 1;
			if (bit == 1)
				sum++;
			n = n >> 1;
			i++;
		}
		return sum;
	}
}
