package leetcodeOJ;

public class _121BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int maxProf = 0, low = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < low)
				low = prices[i];
			else {
				maxProf = prices[i] - low > maxProf ? prices[i] - low : maxProf;
			}
		}
		return maxProf;
	}

	public static void main(String[] args) {
		int[] prices = { 5, 1, 0, 4, 9, 7, 2, 5, 6 };
		System.out.println(maxProfit(prices));
	}
}