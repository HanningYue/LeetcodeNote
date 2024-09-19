class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int row = 0; row < m; row++) {
            dfs(board, row, 0);
            dfs(board, row, n - 1);
        }
        for (int col = 0; col < n; col++) {
            dfs(board, 0, col);
            dfs(board, m - 1, col);
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }
        
        board[row][col] = '#';
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1]);
        }
    }
}