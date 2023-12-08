class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1, visited);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, visited);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j, visited);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
        || visited[i][j] || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        visited[i][j] = true;
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }
}
