//https://leetcode.com/problems/edit-distance/
public class EditDistance{
	public int minDistance(String word1, String word2) {
        if((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0))
            return 0;
        if(word1 == null || word1.length() == 0)    
            return word2.length();
        if(word2 == null || word2.length() == 0)    
            return word1.length();
        int n = word1.length();
        int m = word2.length();
        int [][] memo = new int[n+1][m+1];
        //Initialization
        for(int i = 0; i <= n; i ++){
            memo[i][0] = i;
        }
        for(int i = 0; i <= m; i++){
            memo[0][i] = i;
        }
        //Calc the values
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1];
                else{
                    int min = memo[i-1][j-1];
                    min = min < memo[i-1][j] ? min : memo[i-1][j];
                    min = min < memo[i][j-1] ? min : memo[i][j-1];
                    memo[i][j] = min + 1;
                }    
            }
        }
        return memo[n][m];
    }

}