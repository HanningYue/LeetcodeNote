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
    private int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dpTable[i][j] != -1) {
            return dpTable[i][j];
        }
        dpTable[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return dpTable[i][j];
    }
}