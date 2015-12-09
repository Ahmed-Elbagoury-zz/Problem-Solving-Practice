//https://leetcode.com/problems/unique-paths/
public class UniquePath{
	int [][] memo;
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        memo = new int [m+1][n+1];
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                memo[i][j] = -1;
            }
        }
        memo[m][n] = 1;
        
        return helper(1, 1, m, n);
    }
    
    public int helper(int x, int y, int m, int n){
        if(x > m || y > n)
            return 0;
        if(memo[x][y] == -1){
            int count = helper(x+1, y, m, n);
            count += helper(x, y+1, m, n);
            memo[x][y] = count;
        }
        return memo[x][y];
    }
}