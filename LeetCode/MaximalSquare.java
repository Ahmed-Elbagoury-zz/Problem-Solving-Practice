//https://leetcode.com/problems/maximal-square/
public class MaximalSquare{
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] memo = new int[n][m];
        int max = 0;
        for(int i = 0; i < m; i++){
            memo[0][i] = (int) (matrix[0][i] - '0');
            max = Math.max(max, memo[0][i]);
        }
        for(int i = 0; i < n; i++){
        	memo[i][0] = (int) (matrix[i][0] - '0');
        	max = Math.max(max, memo[i][0]);
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == '0')
                    continue;
                int min = memo[i-1][j];
                if(j > 0){
                    min = Math.min(min, memo[i][j-1]);
                    min = Math.min(min, memo[i-1][j-1]);
                }
                min++;
                memo[i][j] = min;
                max = Math.max(max, min);
            }
        }
        return max*max;
    }
}