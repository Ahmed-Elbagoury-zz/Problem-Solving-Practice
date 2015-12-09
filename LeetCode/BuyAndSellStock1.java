//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStock1{
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;    
        int [] max = new int [n];
        max[n-1] = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            max[i] = max[i+1] > prices[i] ? max[i+1] : prices[i];
        }
        int sol = 0;
        for(int i = 0; i < n; i++){
            int temp =  max[i] - prices[i];
            sol = sol > temp ? sol : temp;
        }
        return sol;
    }

}