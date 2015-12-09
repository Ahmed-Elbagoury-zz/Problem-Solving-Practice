//https://leetcode.com/problems/unique-paths-ii/
public UniquePath2{
	int [][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    memo[i][j] = 0;
                else
                    memo[i][j] = -1;
            }
        }
        if(obstacleGrid[m-1][n-1] != 1)
            memo[m-1][n-1] = 1;
        return helper(0, 0, m, n);
    }
    
    public int helper(int x, int y, int m, int n){
        if(x == m || y == n)
            return 0;
        if(memo[x][y] == -1){
            memo[x][y] = helper(x+1, y, m, n);
            memo[x][y] += helper(x, y+1, m, n);
        }
        return memo[x][y];
    }


}