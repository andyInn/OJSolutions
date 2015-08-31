package leetcodeOJ;

/**
 * 方法二：因为题目要求算法复杂度为O(log(m+n)),使用合并排序并非完全符合题意，在网上发现了一个比较好的思路。
 * 该方法的核心是将原问题转变成一个寻找第k小数的问题（假设两个原序列升序排列），这样中位数实际上是第(m+n)/2小的数。
 * 所以只要解决了第k小数的问题，原问题也得以解决。

 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
 这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
 换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。

 证明也很简单，可以采用反证法。假设

 当A[k/2-1]>B[k/2-1]时存在类似的结论。
 当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数。
 (这里可能有人会有疑问，如果k为奇数，则m不是中位数。这里是进行了理想化考虑，在实际代码中略有不同，是先求k/2，然后利用k-k/2获得另一个数。)

 通过上面的分析，我们即可以采用递归的方式实现寻找第k小的数。此外我们还需要考虑几个边界条件：
 如果A或者B为空，则直接返回B[k-1]或者A[k-1]；
 如果k为1，我们只需要返回A[0]和B[0]中的较小值；
 如果A[k/2-1]=B[k/2-1]，返回其中一个；
 */
import java.util.Arrays;

public class _004MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int total = A.length + B.length;
		if ((total & 0x1) == 1) {
			return getKth(A, B, (total >> 1) + 1);
		} else {
			return (getKth(A, B, (total >> 1)) + getKth(A, B, (total >> 1) + 1)) / 2;
		}
	}

	private static double getKth(int[] A, int[] B, int k) {
		int m = A.length, n = B.length, pa = 0;
		// 始终将长度较短的数组作为第一个参数
		if (m > n)
			return getKth(B, A, k);
		if (m == 0)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[0], B[0]);
		if ((k >> 1) >= m) {
			pa = m;
		} else {
			pa = (k >> 1);
		}
		int pb = k - pa;//如果不是下面两值相等时直接返回其中一个值作为最终结果，那么这里就没必要这么写了

		if (A[pa - 1] < B[pb - 1])
			return getKth(Arrays.copyOfRange(A, pa, m), B, k - pa);
		else if (A[pa - 1] > B[pb - 1])
			return getKth(A, Arrays.copyOfRange(B, pb, n), k - pb);
		else
			return A[pa - 1];//pb保证了这个返回值一定正确
	}

	public static void main(String... strings) {
		int[] A = { 1, 2, 3 };
		int[] B = { 4, 5, 6 };
		System.out.println(findMedianSortedArrays(A, B));
	}
}