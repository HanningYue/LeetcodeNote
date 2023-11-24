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

    private void backTracking(char[][] board, int row, List<int[]> queens) {
        if (queens.size() == board.length) {
            List<String> rows = new ArrayList<>();
            for (char[] rowIndex : board) {
                rows.add(new String(rowIndex));
            }
            result.add(rows);
        }

        for (int column = 0; column < board.length; column++) {
            if (isQueen(row, column, queens)) {
                board[row][column] = 'Q';
                queens.add(new int[]{row, column});
                backTracking(board, row + 1, queens);
                board[row][column] = '.';
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isQueen(int row, int column, List<int[]> queens) {
        for (int[] queen : queens) {
            int dx = Math.abs(row - queen[0]);
            int dy = Math.abs(column - queen[1]);
            if (dx == 0 || dy == 0 || dx == dy) {
                return false;
            }
        }
        return true;
    }
}