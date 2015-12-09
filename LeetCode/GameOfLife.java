//https://leetcode.com/problems/game-of-life/
public class GameOfLife{
	public void gameOfLife(int[][] board) {
         if(board == null || board.length == 0)
             return;
         int m = board.length;
         int n = board[0].length;
         final int LIFE = 1;
         final int DEAD = 0;
         int [] dx = new int [] {-1, 0, 1};    
         int [] dy = new int [] {-1, 0, 1};
         int [][] newBoard = new int [board.length][board[0].length];
         for(int i = 0 ; i < board.length; i++){
             for(int j = 0 ; j < board[i].length; j++){
                 //count
                 int numDead = 0;
                 int numLife = 0;
                 for(int x : dx){
                     for(int y : dy){
                         if(x == 0 && y == 0)
                             continue;
                         int newX = i + x;
                         int newY = j + y;
                         if(newX < 0 || newY < 0 || newX >= m || newY >= n)
                             continue;
                         switch(board[newX][newY]){
                             case LIFE: numLife++; break;
                             case DEAD: numDead++; break;
                         }    
                     }
                 }
                 if(board[i][j] == LIFE && (numLife < 2 || numLife > 3))
                     newBoard[i][j] = DEAD;
                 else if(board[i][j] == LIFE && (numLife == 2 || numLife == 3))
                     newBoard[i][j] = LIFE;
                 else if(board[i][j] == DEAD && numLife == 3)
                     newBoard[i][j] = LIFE;
             }
         }
         for(int i = 0; i < board.length; i ++){
             for(int j = 0 ; j < board[i].length; j++){
                 board[i][j] = newBoard[i][j];
             }
         }     
     }
     //Solving in place
     public void gameOfLife(int[][] board) {
         if(board == null || board.length == 0)
             return;
         int m = board.length;
         int n = board[0].length;
         final int LIFE = 1;
         final int WILL_DIE = 2;
         final int WILL_LIVE = -1;
         final int DEAD = 0;
         int [] dx = new int [] {-1, 0, 1};    
         int [] dy = new int [] {-1, 0, 1};
         int [][] newBoard = new int [board.length][board[0].length];
         for(int i = 0 ; i < board.length; i++){
             for(int j = 0 ; j < board[i].length; j++){
                 //count
                 int numDead = 0;
                 int numLife = 0;
                 for(int x : dx){
                     for(int y : dy){
                         if(x == 0 && y == 0)
                             continue;
                         int newX = i + x;
                         int newY = j + y;
                         if(newX < 0 || newY < 0 || newX >= m || newY >= n)
                             continue;
                         switch(board[newX][newY]){
                             case LIFE: numLife++; break;
                             case WILL_DIE: numLife++; break;
                         }    
                     }
                 }
                 if(board[i][j] == LIFE && (numLife < 2 || numLife > 3))
                     board[i][j] = WILL_DIE;
                 else if(board[i][j] == LIFE && (numLife == 2 || numLife == 3))
                     board[i][j] = LIFE;
                 else if(board[i][j] == DEAD && numLife == 3)
                     board[i][j] = WILL_LIVE;
             }
         }
         for(int i = 0; i < board.length; i ++){
             for(int j = 0 ; j < board[i].length; j++){
                 if(board[i][j] == WILL_LIVE)
                    board[i][j] = LIFE;
                 if(board[i][j] == WILL_DIE)
                    board[i][j] = DEAD;    
             }
         }
     }
}