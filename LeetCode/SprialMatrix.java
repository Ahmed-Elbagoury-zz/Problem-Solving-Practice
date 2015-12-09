//https://leetcode.com/problems/spiral-matrix/
public class SprialMatrix{
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0)
            return sol;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int row = 0;
        int col = 0;
        while(row < m && col < n){
            for(int j = i; j < n-i; j++)
                sol.add(matrix[i][j]);
            for(int j = i+1; j < m -i; j++)    
                sol.add(matrix[j][n-i-1]);
            if(m-i-1 != i)
	            for(int j = n-i-2; j >= i; j--)    
	                sol.add(matrix[m-i-1][j]);
	        if(n-i-1 != i)         
                for(int j = m-i-2; j > i; j--)    
                    sol.add(matrix[j][i]);
            i++;    
            row += 2;
            col += 2;
        }
        return sol;
    }

}