//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class RangeSum2D{
	int [][] matrix;
    int [][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        this.matrix = matrix;
        this.sum = new int [matrix.length][matrix[0].length];
        //initialize the first row and column of the sum
        sum[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++)
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        for(int i = 1; i < matrix[0].length; i++)
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        //Compute the sum for the rest of the matrix sum(i, j) = sum(i-1, j) + sum(i, j - 1) - sum(i-1, j-1)
        for(int i = 1; i < matrix.length; i ++){
            for(int j = 1; j < matrix[0].length; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix == null || matrix.length == 0)
            return 0;
        return sum[row2] [col2] - (col1 > 0 ? sum[row2][col1-1] : 0) - (row1 > 0? sum[row1-1][col2] : 0) + (row1 > 0 && col1 > 0 ? sum[row1-1][col1-1] : 0);    
    }

}