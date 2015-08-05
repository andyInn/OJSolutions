package leetcodeOJ;
/**
 **分析**：  
  
DP 公式为：  
`dp[i] = dp[k] * dp[i-k-1] { 0<=k<=i-1 }`  
可以这样理解：  
求 {1, 2, ...., i} 的 BST，我们拿其中的一个数作根（假设为 k），
根据 BST 的特性，左子树就是 {1, 2, ..., k-1}，右子树就是 {k+1, k+2, ..., i} 了。  
而很明显 {k+1, k+2, ..., i} 化 BST 的可能性和 {1, 2, ..., i-(k+1)} 是一样的。  
记 {1, 2, ..., n} 的 BST 个数为 f(n)，上述就可以表达为 `f(i) = f(k-1) * f(i-k-1)`。  
而我们选择的 k 就是 {1, 2, ...., i} 中的任意一个，而不同的 k 等到的 BST 是不会重复的。  
 * @author Andy
 *
 */
public class _096UniqueBinarySearchTrees {
	/**
	 * 221ms
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        int sum = 0, a[] = new int[n];
        for (int i = 0; i < a.length; i++)  a[i]=numTrees(i);
        for (int k = 0; k < n; k++) sum += a[k]*a[n-k-1];
        return sum;
    }
	
	/**
	 * 215ms
	 * @param n
	 * @return
	 */
	public int numTrees2(int n) {
		if(n==0 || n==1) return 1;
        if(n==2) return 2;
        int dp[] = new int[n+1];
        dp[0]=dp[1]=1; dp[2]=2;
        for (int i = 3; i <= n; i++)
        	for (int k = 0; k < i; k++)
        		dp[i] += dp[k] * dp[i - k - 1];
        return dp[n];
	}
    
    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
    	_096UniqueBinarySearchTrees sl = new _096UniqueBinarySearchTrees();
		System.out.println(sl.numTrees(18));
		System.out.println(sl.numTrees(15));
		System.out.println(sl.numTrees(15));
		long endTime = System.currentTimeMillis();
		System.out.printf("Runtime is:%d ms", endTime - startTime);
	}
}