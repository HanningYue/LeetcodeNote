class Solution {
    Integer[][] dpTable;
    public int uniquePaths(int m, int n) {
        dpTable = new Integer[m][n];
        return dp(dpTable, m - 1, n - 1);
    }
    private int dp(Integer[][] dpTable, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int goLeft = dp(dpTable, row, col - 1);
        int goUp = dp(dpTable, row - 1, col);
        dpTable[row][col] = goLeft + goUp;
        return dpTable[row][col];
    }
}