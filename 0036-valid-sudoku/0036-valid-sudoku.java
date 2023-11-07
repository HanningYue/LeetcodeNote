/*
Logic : 
We iterate two large cycle, the outer cycle and the inner cycle, for outer cycle, increase index by 3, for inner cycle, right-boundary is 3
1. First for the Bigger grid, 0 to 9 row, 0 to 9 column
    board[i][j] -> board[j][i] if not '.' Check set duplicate, if so return false
    if not, add to set
2. Second for the smaller grid, 0 to 9 row, but increase every 3 steps each
3. We need a helper function which 0 to 3, increase 1 each step
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!helper(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean helper(int rowIndex, int colIndex, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
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