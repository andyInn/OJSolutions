package leetcodeOJ;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) return 0;
        int buy = prices[0], sell = prices[0], maxBenefit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                sell = prices[i];
                maxBenefit = (sell - buy > maxBenefit ? sell - buy : maxBenefit);
            }
        }
        return maxBenefit;
    }
}
