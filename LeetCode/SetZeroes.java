//http://oj.leetcode.com/problems/set-matrix-zeroes/
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        boolean [] rows = new boolean [matrix.length];
        boolean [] cols = new boolean [matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true; 
                }
            }
        }
        for(int i = 0; i < rows.length; i++){
            if(rows[i]){
                for(int j = 0; j < matrix[0].length; j++) matrix[i][j] = 0;
            }
        }
        
        for(int j = 0; j < cols.length; j++){
            if(cols[j]){
                for(int i = 0; i < matrix.length; i++) matrix [i][j] =0;
            }
        }    
    }
    //without extra space
    public void setZeroesWithoutExtraSpace(int[][] matrix) {
       boolean firstRow = false;
       boolean firstCol = false;
       //Mark first row
       for(int j = 0; j < matrix[0].length; j++){
           if(matrix[0][j] == 0){
               firstRow = true;
               break;
           }
       }
       //Mark first column
       for(int i = 0; i < matrix.length; i++){
           if(matrix[i][0] == 0){
               firstCol = true;
               break;
           }
       }
       //Mark the rest of rows and columns
       for(int i = 1; i < matrix.length; i++){
           for(int j = 1; j < matrix[i].length; j++){
               if(matrix[i][j] == 0){
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
               }
           }
       }
       //Change the values in the rest of rows and columns
       for(int i = 1; i < matrix.length; i++){
           for(int j = 1; j < matrix[i].length; j++){
               if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
           }
       }
       //Change the values of the first row and column
       if(firstRow){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
       }
       if(firstCol){
           for(int i = 0; i < matrix.length; i++){
               matrix[i][0] = 0;
           }       }           }
}


