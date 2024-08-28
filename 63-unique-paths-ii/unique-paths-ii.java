class Solution {
    Integer[][] dpTable;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dpTable = new Integer[m][n];
        return dp(obstacleGrid, m - 1, n - 1);
    }
    private int dp(int[][] obstacleGrid, int row, int col) {
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }

        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }

        int goLeft = dp(obstacleGrid, row, col - 1);
        int goUp = dp(obstacleGrid, row - 1, col);
        dpTable[row][col] = goLeft + goUp;
        return dpTable[row][col];
    }
}