/**
1. Fill char[][]board with '.'
2. If difference between dx and dy is 0 or Diagonally, the dx == dy, return false
3. When filling final result, declare new List<String> for each iteration (fill new list with char[] rows)
*/
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
        backTracking(result, queens, 0, board);
        return result;
    }
    
    private void backTracking(List<List<String>> result, List<int[]> queens, int row, char[][] board) {
        if (queens.size() == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) {
                list.add(new String(r));
            }
            result.add(list);
            return;
        }

        for (int column = 0; column < board[0].length; column++) {
            if (isQueen(queens, row, column)) {
                board[row][column] = 'Q';
                queens.add(new int[]{row, column});
                backTracking(result, queens, row + 1, board);
                queens.remove(queens.size() - 1);
                board[row][column] = '.';
            }
        }
    }

    private boolean isQueen(List<int[]> queens, int row, int column) {
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