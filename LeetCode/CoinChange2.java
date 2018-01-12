class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] memo = new int [amount+1][n+1];
        for(int j = 0; j < n+1; j++){
            memo[0][j] = 1;
        }
        for(int i = 1; i < amount + 1; i++){
            for(int j = 1; j < n+1; j++){
                memo[i][j] = memo[i][j-1];
                if(i >= coins[j-1]){
                    memo[i][j] += memo[i-coins[j-1]][j];
                }
            }
        }
        return memo[amount][n];
    }
   
}
