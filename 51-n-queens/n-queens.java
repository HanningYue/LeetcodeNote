class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<int[]> queens = new ArrayList<>();
        backTracking(board, 0, queens);
        return result;
    }

    private void backTracking(char[][] board, int r, List<int[]> queens) {
        if (queens.size() == board.length) {
            List<String> rows = new ArrayList<>();
            for (char[] row : board) {
                rows.add(new String(row));
            }
            result.add(rows);
        }

        for (int c = 0; c < board.length; c++) {
            if (isQueen(r, c, queens)) {
                board[r][c] = 'Q';
                queens.add(new int[]{r, c});
                backTracking(board, r + 1, queens);
                board[r][c] = '.';
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isQueen(int r, int c, List<int[]> queens) {
        for (int[] queen : queens) {
            int dx = Math.abs(r - queen[0]);
            int dy = Math.abs(c - queen[1]);
            if (dx == 0 || dy == 0 || dx == dy) {
                return false;
            }
        }
        return true;
    }
}