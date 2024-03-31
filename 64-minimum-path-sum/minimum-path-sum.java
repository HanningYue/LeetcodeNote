class Solution {
    Integer[][] dpTable;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dpTable = new Integer[m][n];
        return dp(grid, m - 1, n - 1);
    }
    private int dp(int[][] grid, int row, int col) {
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        int up = dp(grid, row - 1, col);
        int left = dp(grid, row, col - 1);
        dpTable[row][col] = Math.min(up, left) + grid[row][col];
        return dpTable[row][col];
    }
}