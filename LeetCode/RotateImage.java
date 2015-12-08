//https://leetcode.com/problems/rotate-image/
public class RotateImage {
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i ++){
            for(int j=i; j < n-i-1; j++){
                int temp = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                int temp2 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp;
                temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp2;
                matrix[i][j] = temp;
            }
        }
    }
}

