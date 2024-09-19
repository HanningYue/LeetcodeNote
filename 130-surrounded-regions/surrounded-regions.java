class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            dfs(board, row, 0, visited);
            dfs(board, row, n - 1, visited);
        }
        for (int col = 0; col < n; col++) {
            dfs(board, 0, col, visited);
            dfs(board, m - 1, col, visited);
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
    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }

        if (board[row][col] == 'O') {
            board[row][col] = '#';
        } else {
            return;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], visited);
        }
    }
}