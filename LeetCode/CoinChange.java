//https://leetcode.com/problems/coin-change/
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
