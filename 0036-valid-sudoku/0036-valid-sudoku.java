/*
We iterate two large cycle, the outer cycle and the inner cycle, for outer cycle, increase index by 3, for inner cycle, right-boundary is 3
1. First for the Bigger grid, 0 to 9 row, 0 to 9 column
    board[i][j] -> board[j][i] if not '.' Check set duplicate, if so return false
    if not, add to set //We need to declear Set inside OUTER loop
2. Second for the smaller grid, 0 to 9 row, but increase every 3 steps each
    We need a helper function which 0 to 3, increase 1 each step
The logic :
1 1 1 1 1 1     1 1 1 1 1 1     1 1 1 1 1 1
1               1 1 1 1 1 1     1 1 1 1 1 1
1               1 1             1 1 1 1 1 1 
1               1 1             1 1 1
1               1 1             1 1 1
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] != '.') {
                    if (rowSet.contains(board[row][column])) {
                        return false;
                    }
                    rowSet.add(board[row][column]);
                }
                if (board[column][row] != '.') {
                    if (columnSet.contains(board[column][row])) {
                        return false;
                    }
                    columnSet.add(board[column][row]);
                }
            }
        }
        for (int innerRow = 0; innerRow < board.length; innerRow += 3) {
            for (int innerColumn = 0; innerColumn < board.length; innerColumn += 3) {
                if (!dfs(innerRow, innerColumn, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int row, int column, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}