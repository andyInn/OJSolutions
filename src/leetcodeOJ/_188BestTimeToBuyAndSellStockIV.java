package leetcodeOJ;
/**
 * 参考链接
 * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 * @author Andy
 *
 */
public class _188BestTimeToBuyAndSellStockIV {
	public static int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (prices == null || n < 2 || k <= 0)
			return 0;
		if (k >= n) return maxProfit2(prices);
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
	
	public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
	
	public static void main(String... strings) {
		int[] prices = { 3,2,6,5,0,3 };
//		int[] prices = { 1,10,2,12 };
		System.out.println(maxProfit(2, prices));
	}
}
