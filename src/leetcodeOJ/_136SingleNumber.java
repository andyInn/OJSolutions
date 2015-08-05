package leetcodeOJ;

public class _136SingleNumber {
	public static void main(String[] args) {
		_136SingleNumber sl = new _136SingleNumber();
		int[] A = {1,2,5,2,7,1,7};
		System.out.println(sl.singleNumber(A));
	}

	public int singleNumber(int[] A) {
		int result = A[0];
		if(A == null || A.length == 0) return 0;
		for (int i = 1; i < A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}
}
