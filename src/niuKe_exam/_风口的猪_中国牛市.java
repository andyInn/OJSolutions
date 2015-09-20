package niuKe_exam;

public class _风口的猪_中国牛市 {
	public static int calculateMax(int[] prices) {
		int n = prices.length, k = 2;
		if (prices == null || n < 2)
			return 0;
		int max = Math.max(prices[1] - prices[0], 0);
		if (prices.length == 2)
			return max;
		int[][] dp = new int[n][k + 1];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				max = dp[i - 1][j];//前一天交易了j笔
				for (int j2 = i - 1; j2 >= 0; j2--) {
					max = Math.max(max, dp[j2][j - 1] + prices[i] - prices[j2]);
				}
				dp[i][j] = max;
			}
		}
		return dp[n - 1][k];
	}
	
	public static int calculateMax2(int[] prices) {
		int n = prices.length, k = 2;
		if (prices == null || n < 2)
			return 0;
		int[] local = new int[k + 1];
		int[] global = new int[k + 1];
		for (int i = 1; i < n; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j > 0; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}
	public static void main(String... strings) {
//		int[] prices = { 3 };
		int[] prices = { 1,10,2,12 };
		System.out.println(calculateMax2(prices));
	}
}