//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //validate rows
        boolean [][] rows = new boolean [board.length][10];
        boolean [][] cols = new boolean [board[0].length][10];
        boolean [][] blks = new boolean [9][10];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                int cur = (int) (board[i][j] - '0');
                if(rows[i][cur] || cols[j][cur] || blks[(i/3)*3 + j/3][cur]) return false;
                rows[i][cur] = true;
                cols[j][cur] = true;
                blks[(i/3)*3 + j/3][cur] = true;
            }
        }
        return true;
    }
}

