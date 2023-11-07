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
        int n = board.length;
        for (int i = 0; i < n; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (column.contains(board[j][i])) {
                        return false;
                    }
                    column.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                if (!helper(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean helper(int row, int column, char[][] board) {
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