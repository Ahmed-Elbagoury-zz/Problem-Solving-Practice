//https://leetcode.com/problems/minimum-path-sum/
public class MinPathSum{
	int [][] memo;
     int min = 0;
     int [][] grid;
     public int minPathSum(int[][] grid) {
         if(grid == null || grid.length == 0)
             return 0;
         this.grid = grid;    
         memo = new int [grid.length][grid[0].length];
         for(int i = 0; i < memo.length; i++){
             for(int j = 0; j < memo[0].length; j++)
                 memo[i][j] = -1;
         }
         return helper(0, 0);
     }
     
     public int helper(int x, int y){
         if(x == memo.length && y == memo[0].length)  
             return 0;
         if(memo[x][y] == -1){
        	 memo[x][y] = grid[x][y];
        	 int temp = Integer.MAX_VALUE;
        	 if(y < memo[0].length - 1)
        		 temp = helper(x, y+1);
        	 if(x < memo.length - 1)
        		 temp = Math.min(temp, helper(x+1, y));
        	 if(temp != Integer.MAX_VALUE)	 
        	    memo[x][y] += temp;
             
         }
         return memo[x][y];
     }

}