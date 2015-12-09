//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuyAndSellStock3{

//This can be solved by "devide and conquer". We use left[i] to track the maximum profit for transactions before i, and use right[i] to track the maximum profit for transactions after i

 public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;    
        int [] left = new int [n];
        int [] right = new int [n];
        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i < n; i++){
            if(prices[i] < min){
                min = prices[i];
                left[i] = left[i-1];
            }
            else{
                int temp = prices[i] - min;
                left[i] = temp > left[i-1] ? temp : left[i-1]; 
            }
        }
        right[n-1] = 0;
        int max = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            if(prices[i] > max){
                max = prices[i];
                right[i] = right[i+1];
            }
            else{
                int temp = max - prices[i];
                right[i] = temp > right[i+1] ? temp : right[i+1];
            }
        }
        int profit = 0;
        for(int i = 0; i < n; i++){
            profit = profit > left[i] + right[i] ? profit : left[i] + right[i];
        }
        return profit;
    }
}