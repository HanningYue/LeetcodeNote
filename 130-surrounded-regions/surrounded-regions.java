class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, visited);
            }
            if (board[row][n - 1] == 'O') {
                dfs(board, row, n - 1, visited);
            }
        }

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col, visited);
            }
            if (board[m - 1][col] == 'O') {
                dfs(board, m - 1, col, visited);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
        || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#';
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], visited);
        }
    }
}