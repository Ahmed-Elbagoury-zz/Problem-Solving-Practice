//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands{
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] flag = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0' || flag[i][j])
                    continue;
                count++;    
                Queue<int []> q = new LinkedList<int []>();
                q.add(new int [] {i, j});
                flag[i][j] = true;
                while(! q.isEmpty()){
                    int [] cur = q.remove();
                    int row = cur[0];
                    int col = cur[1];
                    if(row > 0 && grid[row-1][col] == '1' && !flag[row-1][col]){
                        q.add(new int []{row-1, col});
                        flag[row-1][col] = true;
                    }
                    if(row < n-1 && grid[row+1][col] == '1' && !flag[row+1][col]){
                        q.add(new int []{row+1, col});
                        flag[row+1][col] = true;
                    }
                    if(col > 0 && grid[row][col-1] == '1' &&!flag[row][col-1]){
                        q.add(new int []{row, col-1});
                        flag[row][col-1] = true;
                    }
                    if(col < m -1 && grid [row][col+1] == '1' && !flag[row][col+1]){
                        q.add(new int [] {row, col+1});
                        flag[row][col+1] = true;
                    }
                }
            }
        }
        return count;
    }

}