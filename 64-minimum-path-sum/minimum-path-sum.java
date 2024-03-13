class Solution {
    int[][] dpTable;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dpTable = new int[m][n];
        for (int[] row : dpTable) {
            Arrays.fill(row, -1);
        }

        return dp(grid, m - 1, n - 1);
    }
    private int dp(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dpTable[row][col] != -1) {
            return dpTable[row][col];
        }
        dpTable[row][col] = 
        Math.min(dp(grid, row - 1, col), dp(grid, row, col - 1)) + grid[row][col];
        return dpTable[row][col];
    }
}