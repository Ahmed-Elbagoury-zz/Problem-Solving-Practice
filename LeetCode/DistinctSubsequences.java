//https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences{
	public int numDistinct(String s, String t) {
        if(s == null || t == null)
            return 0;
        int [][] memo = new int [s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            memo[i][0] = 1;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }
        return memo[s.length()][t.length()];
    }
}