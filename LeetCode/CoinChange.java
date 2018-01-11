//https://leetcode.com/problems/coin-change/
class Solution2 {
    final int NOT_COMPUTE_YET = -2;
    final int NOT_FEASIBLE = -1;
    public int coinChange(int[] coins, int amount) {
        int [] memo = new int [amount+1];
        memo[0] = 0;
        for(int i = 1; i < amount+1; i++){
            memo[i] = NOT_COMPUTE_YET;
        }
        return coinChange(coins, amount, memo);
    }
    
    private int coinChange(int [] coins, int amount, int[] memo){
        if(amount < 0) return -1;
        int minAmount = NOT_FEASIBLE;
        if(memo[amount] == NOT_COMPUTE_YET){
            for(int i = 0; i < coins.length; i++){
                int temp = coinChange(coins, amount - coins[i], memo);
                if(temp != NOT_FEASIBLE){
                    if(minAmount == NOT_FEASIBLE){
                        minAmount = temp + 1;
                    }
                    else{
                        minAmount = Math.min(minAmount, temp+1);
                    }
                }
            }
            memo[amount] = minAmount;
        }
        return memo[amount];
    }
}

public class Solution {
    int[]memo;
    int [] coins;
    public int coinChange(int[] coins, int amount) {
        if(coins == null || amount == 0)
            return 0;
       int n = coins.length;
       int [][]memo = new int [amount+1][n];
       for(int i = 1; i <= amount; i++){
    	   for(int j = 0; j < n; j++){
    		   memo[i][j] = -1;
    	   }
       }
       for(int j = 0; j < n; j++)
    	   memo[0][j] = 0;
       for(int i = 1; i <= amount; i++){
    	   for(int j = 0 ; j < n; j++){
    		   int newAmount = i - coins[j];
    		   int x = -1;
    		   if(newAmount >= 0){
    		      if(memo[newAmount][j] != -1) 
    			    x = memo[newAmount][j] + 1; 
    		   }
    		   int y  = -1;
    		   if(j > 0)
    			   y = memo[i][j-1];   
    		   if(x == -1)
    			   memo[i][j] = y;
    		   else if(y == -1)
    			   memo[i][j] = x;
    		   else
    			   memo[i][j] = x < y ? x : y;
    	   }
       }
       return memo[amount][n-1];
    }
    
    
    public static void main(String [] args){
    	Solution solution = new Solution();
    	System.out.println(solution.coinChange(new int [] {1, 2, 5}, 100));
    }
}
