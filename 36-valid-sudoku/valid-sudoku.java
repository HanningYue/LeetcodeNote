class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int row = 0; row < m; row++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (board[row][col] != '.' && !rowSet.add(board[row][col])) {
                    return false;
                }
                if (board[col][row] != '.' && !colSet.add(board[col][row])) {
                    return false;
                }
            }
        }

        for (int row = 0; row < m; row += 3) {
            for (int col = 0; col < n; col += 3) {
                Set<Character> visited = new HashSet<>();
                if (!valid(board, row, col, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, Set<Character> visited) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.' && !visited.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}