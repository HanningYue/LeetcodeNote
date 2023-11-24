class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<int[]> queens = new ArrayList<>();
        backTracking(result, board, queens, 0);
        return result;
    }

    private void backTracking(List<List<String>> result, char[][] board, List<int[]> queens, int row) {
        
        if (queens.size() == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] rows : board) {
                list.add(new String(rows));
            }
            result.add(list);
        }

        for (int column = 0; column < board[0].length; column++) {
            if (isQueen(row, column, queens)) {
                board[row][column] = 'Q';
                queens.add(new int[]{row, column});
                backTracking(result, board, queens, row + 1);
                queens.remove(queens.size() - 1);
                board[row][column] = '.';
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