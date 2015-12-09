//https://leetcode.com/problems/triangle/
public class Triangle{
	//O(n^2) memory

     int [][] memo;
     boolean [][] isVisited;
     public int minimumTotal(List<List<Integer>> triangle) {
         if(triangle == null || triangle.size() == 0)
             return 0;
         int n = triangle.size(); 
         memo = new int [n][n];
         isVisited = new boolean[n][n];
         for(int i = 0; i < n-1; i++){
        	 for(int j = 0; j < n; j++){
        		 isVisited[i][j] = false;
        	 }
         }
         for(int i = 0; i < n; i++){
             memo[n-1][i] = triangle.get(n-1).get(i);
             isVisited[n-1][i]= true;
         }
         return helper(0, 0, triangle);
     }
     
     public int helper(int row, int col, List<List<Integer>> triangle){
         if(row == triangle.size())
             return 0;
         if(!isVisited[row][col]){    
             int val1 = helper(row+1, col, triangle);
             int val2 = helper(row+1, col+1, triangle);
             int max = val1 < val2? val1 : val2;
             memo[row][col] = max + triangle.get(row).get(col);
             isVisited[row][col] = true;
         }
         return memo[row][col];
         
     }
     //O(n) memory
     public int minimumTotalOrderN(List<List<Integer>> triangle) {
         if(triangle == null || triangle.size() == 0)
             return 0;
         int n = triangle.size(); 
         int [] memo1 = new int [n];
         int [] memo2 = new int [n];
         for(int i = 0; i < n; i++){
             memo2[i] = triangle.get(n-1).get(i);
         }
         
         for(int i = n-2; i >= 0; i--){
             for(int j = 0; j <= i ; j++){
                 memo1[j] = triangle.get(i).get(j) + Math.min(memo2[j], memo2[j+1]);
             }
             memo2 = memo1;
             memo1 = new int [n];
         }
         return memo2[0];
     }
}