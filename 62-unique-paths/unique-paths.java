class Solution {
    int[][] dpTable;
    public int uniquePaths(int m, int n) {
        dpTable = new int[m][n];
        for (int[] row : dpTable) {
            Arrays.fill(row, 0);
        }

        return dp(m - 1, n - 1);
    }
    private int dp(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dpTable[row][col] != 0) {
            return dpTable[row][col];
        }

        int result = dp(row - 1, col) + dp(row, col - 1);
        dpTable[row][col] = result;
        return result;
    }
}