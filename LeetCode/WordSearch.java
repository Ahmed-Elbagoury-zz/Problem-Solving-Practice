//http://oj.leetcode.com/problems/word-search/
public class WordSearch {
    int [] dx = new int []{ 0,0,1,-1};
    int [] dy = new int []{-1,1,0, 0};
    char [][] board;
    String word;
    boolean [] [] visisted;
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        this.board = board;
        this.word = word;
        this.visisted = new boolean[board.length][board[0].length];
        boolean flag = false;
        for(int i = 0; i < board.length; i ++){
        	for(int j = 0; j < board[0].length; j++){
        		flag = helper(i, j, 0);
        		if(flag) return flag;
        	}
        		
        }
        return flag;
    }
    
    public boolean helper(int row, int col, int ind){
        if(board[row][col] != word.charAt(ind)) return false;
        if(ind == word.length()-1) return true;
        visisted[row][col] = true;
        int newRow, newCol;
        boolean flag = false;
        for(int i = 0; i < dx.length && !flag; i++){
            newRow = row + dx[i];
            newCol = col + dy[i];
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || 
            		visisted[newRow][newCol])
                continue;
            flag = helper(newRow, newCol, ind+1);    
        }
        visisted[row][col] = false;
        return flag;
    }  
}