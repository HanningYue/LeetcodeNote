class Solution {
    Integer[][] dpTable;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dpTable = new Integer[m][n];
        return dp(obstacleGrid, m - 1, n - 1);
    }
    private int dp(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int left = dp(grid, row, col - 1);
        int up = dp(grid, row - 1, col);
        dpTable[row][col] = left + up;
        return dpTable[row][col];
    }
}