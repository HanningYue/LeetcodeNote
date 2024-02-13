class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!smallGrid(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean smallGrid(int row, int col, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}