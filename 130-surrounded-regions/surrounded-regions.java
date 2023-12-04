class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][columns - 1] == 'O') {
                dfs(board, i, columns - 1);
            }
        }
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != 'O') {
            return;
        }
        board[row][column] = '#';
        dfs(board, row + 1, column);
        dfs(board, row - 1, column);
        dfs(board, row, column + 1);
        dfs(board, row, column - 1);
    }
}