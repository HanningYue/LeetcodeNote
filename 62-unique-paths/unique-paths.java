class Solution {
    int[][] dpTable;
    public int uniquePaths(int m, int n) {
        dpTable = new int[m][n];
        for (int[] row : dpTable) {
            Arrays.fill(row, 0);
        }

        return dp(m - 1, n - 1);
    }
    private int dp(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) {
            return 0;
        }
        if (dpTable[x][y] != 0) {
            return dpTable[x][y];
        }
        dpTable[x][y] = dp(x - 1, y) + dp(x, y - 1);
        return dpTable[x][y]; 
    }
}