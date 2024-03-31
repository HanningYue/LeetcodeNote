class Solution {
    Integer[][] dpTable;
    public int uniquePaths(int m, int n) {
        dpTable = new Integer[m][n];
        return dp(m - 1, n - 1);
    }
    private int dp(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dpTable[m][n] != null) {
            return dpTable[m][n];
        }
        int up = dp(m - 1, n);
        int left = dp(m, n - 1);
        dpTable[m][n] = up + left;
        return dpTable[m][n];
    }
}