class Solution {
    Integer[][] dpTable;
    public int uniquePaths(int m, int n) {
        dpTable = new Integer[m][n];
        return dp(m - 1, n - 1);
    }
    private int dp(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }

        int up = dp(row - 1, col);
        int left = dp(row, col - 1);
        dpTable[row][col] = up + left;
        return dpTable[row][col];
    }
}