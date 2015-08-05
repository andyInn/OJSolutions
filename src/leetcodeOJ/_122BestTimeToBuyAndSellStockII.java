package leetcodeOJ;

public class _122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if(len == 0 || len == 1) return 0;
        int sum = 0 , thisSum = 0, pre = prices[0], now = 0;
        for (int i = 1; i < len; i++) {
			now = prices[i];
			if((thisSum = now-pre)>0) sum+=thisSum;
			pre = now;
		}
        return sum;
    }
    
    public static void main(String[] args) {
		int[] p = new int[]{1,2,20,11,35,28,23,19,50};
		_122BestTimeToBuyAndSellStockII sl = new _122BestTimeToBuyAndSellStockII();
		System.out.println(sl.maxProfit(p));;
	}
}