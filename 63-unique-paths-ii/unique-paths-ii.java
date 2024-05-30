class Solution {
    Integer[][] dpTable;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dpTable = new Integer[m][n];
        return dp(m - 1, n - 1, obstacleGrid);
    }
    private int dp(int row, int col, int[][] board) {
        if (row < 0 || col < 0 || board[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        int moveUp = dp(row - 1, col, board);
        int moveLeft = dp(row, col - 1, board);
        dpTable[row][col] = moveUp + moveLeft;
        return dpTable[row][col];
    }
}