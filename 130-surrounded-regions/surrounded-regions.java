class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 
        || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1]);
        }
    }
}