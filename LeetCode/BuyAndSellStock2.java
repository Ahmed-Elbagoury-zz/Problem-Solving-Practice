//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuyAndSellStock2{
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int profit = 0;    
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            profit += diff > 0 ? diff : 0;
        }
        return profit;
    }

}