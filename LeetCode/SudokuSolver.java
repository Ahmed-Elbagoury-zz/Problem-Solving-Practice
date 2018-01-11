class Solution {
    public void solveSudoku(char[][] board) {
        List<Set<Character>> rowSets = new LinkedList<Set<Character>>();
        List<Set<Character>> columnSets = new LinkedList<Set<Character>>();
        List<Set<Character>> boxSets = new LinkedList<Set<Character>>();
        for(int i = 0; i < 9; i++){
            rowSets.add(new HashSet<Character>());
            columnSets.add(new HashSet<Character>());
            boxSets.add(new HashSet<Character>());
        }
        for(int index = 0; index < 9 * 9; index++){
            int row = index / 9;
            int column = index % 9;
            int boxIndex = (row/3) * 3 + column/3;
            char c = board[row][column];
            if(c == '.'){
                continue;
            }
            rowSets.get(row).add(c);
            columnSets.get(column).add(c);
            boxSets.get(boxIndex).add(c);
        }
        solveSudoku(board, 0, rowSets, columnSets, boxSets);
    }
    public boolean solveSudoku(char[][] board, int index, List<Set<Character>> rowSets, List<Set<Character>> columnSets, List<Set<Character>> boxSets){
        if(index == 9 * 9){
            return true;
        }
        int row = index / 9;
        int column = index % 9;
        int boxIndex = (row/3) * 3 + column/3;
        for(char c = '1'; c <= '9'; c++){
            if(board[row][column] != '.'){
                return solveSudoku(board, index +1, rowSets, columnSets, boxSets);
            }
            if(rowSets.get(row).contains(c) || columnSets.get(column).contains(c) || boxSets.get(boxIndex).contains(c)){
                continue;
            }
            rowSets.get(row).add(c);
            columnSets.get(column).add(c);
            boxSets.get(boxIndex).add(c);
            board[row][column] = c;
            if(solveSudoku(board, index+1, rowSets, columnSets, boxSets)){
                return true;
            }
            board[row][column] = '.';
            rowSets.get(row).remove(c);
            columnSets.get(column).remove(c);
            boxSets.get(boxIndex).remove(c);
        }
        return false;
    }
}
