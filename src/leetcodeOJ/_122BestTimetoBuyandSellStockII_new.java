package leetcodeOJ;

public class _122BestTimetoBuyandSellStockII_new {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length<2) return 0;
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) sum += prices[i]-prices[i-1];
        }
        return sum;
    }
}
