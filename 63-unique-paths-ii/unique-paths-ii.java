class Solution {
    int[][] dpTable;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dpTable = new int[m][n];
        for (int[] row : dpTable) {
            Arrays.fill(row, 0);
        }

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
        if (dpTable[row][col] != 0) {
            return dpTable[row][col];
        }
        
        int result = dp(grid, row, col - 1) + dp(grid, row - 1, col);
        dpTable[row][col] = result;
        return result;
    }
}