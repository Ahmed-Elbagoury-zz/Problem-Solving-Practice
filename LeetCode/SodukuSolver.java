//https://leetcode.com/problems/sudoku-solver/
public class SodukuSolver {
	public static void main (String [] args){
		char [][] c = new char [][] 
				{{'.','.','9','7','4','8', '.', '.','.'},
				 {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
				 {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
				 {'.', '.', '7', '.', '.', '.' ,'2', '4', '.'},
				 {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
				 {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
				 {'.', '.', '.' , '8', '.', '3', '.', '2', '.'},
				 {'.', '.', '.', '.', '.', '.', '.', '.', '6' },
				 {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
				} ;
		new Solution().solveSudoku(c);
	}
	
    char [] [] board;
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        this.board = board;
        solve();
        
    }
    
    public boolean solve (){
        //find first empty position
        int i = -1;
        int j  = -1;
        boolean flag = false;
        for(i = 0 ; i < board.length && !flag; i++){
            for(j = 0; j < board.length && !flag; j++)
                if(board[i][j] == '.') {flag = true;break;}
            if(flag) break;
        }
        //Base case
        if(i == board.length || j == board.length){ return true;}
        for(int c = 0; c < 9; c++){
            board[i][j] = (char) (c + 1+ '0');
            if( isValid(i, j) && solve() ){ return true;}
            board[i][j] = '.';
        }
        return false;
    }
    
    public boolean isValid (int row, int col){
        boolean [] rowFlags = new boolean [9];
        boolean [] colFlags = new boolean [9];
        boolean [] blks = new boolean [9];
        
        //For row
        for(int i = 0; i < 9; i ++){
            if(board[row][i] == '.') continue;
            int cur = board[row][i] -'0' -1;
            if(rowFlags[cur]) return false;
            rowFlags[cur] = true;
        }
        
        //For col
        for(int i =0; i < 9 ; i++){
            if(board[i][col] == '.') continue;
            int cur = board[i][col] - '0' - 1;
            if(colFlags [cur]) return false;
            colFlags[cur] = true;
        }
        
        //for blk
        int blkrow = row - row % 3;
        int blkcol = col - col%3;
        for(int i = blkrow; i < blkrow + 3; i ++){
            for(int j = blkcol ; j < blkcol + 3; j++){
                if(board[i][j] == '.') continue;
                int cur = board[i][j] - '0' - 1;
                if(blks[cur]) return false;
                blks[cur] = true;
            }
        }
        return true;
    }
}


