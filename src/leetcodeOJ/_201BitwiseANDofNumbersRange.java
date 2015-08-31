package leetcodeOJ;
/**
 * 参考LeetCode Discuss链接：
 * https://leetcode.com/discuss/32053/accepted-c-solution-with-simple-explanation
   
   [m, n]范围的按位与的结果为m与n的公共“左边首部（left header）”
   别人的代码：//the result of a range bitwise is the common 'left header' of m and n.
   int rangeBitwiseAnd(int m, int n) {
	    int c=0;
	    while(m!=n){
	        m>>=1;
	        n>>=1;
	        ++c;
	    }
	    return n<<c;
	}
 * @author Andy
 *
 */
public class _201BitwiseANDofNumbersRange {
	/**
	 * 本方法也是要求the 'left header' of m and n。
	 * 因为n &= (n - 1);每次使得n的最后面那个1变为0，同时n的二进制位数保持不变，
	 * 所以当n==m时会退出while循环，即为所求.
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rangeBitwiseAnd(int m, int n) {
		while (n > m)
			n &= (n - 1);
		return n;
	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(8, 10));
//		System.out.println(Integer.toBinaryString(8).length());
	}

}