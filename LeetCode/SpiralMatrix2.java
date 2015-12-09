//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrix2{
	public int[][] generateMatrix(int n) {
        if(n < 1)
            return new int [0][0];
        int [][] result = new int [n][n];    
        int val = 1;
        int row = 0;
        int col = 0;
        int i = 0;
        while(row < n && col < n){
            for(int j = i; j < n-i; j++)
                result[i][j] = val++;
            for(int j = i+1; j < n-i; j++)    
                result[j][n-1-i] = val++;
            if(n-i-1 != i)
                for(int j = n-2-i; j >= i; j--)
                    result[n-1-i][j] = val++;
            if(n-1-i != i)
                for(int j = n-2-i; j >i; j--)
                    result[j][i] = val++;
            i++;
            row += 2;
            col += 2;
        }
        return result;
    }


}