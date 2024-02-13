class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();

            for (int j = 0; j < board.length; j++) {
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