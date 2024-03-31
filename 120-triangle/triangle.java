class Solution {
    Integer[][] dpTable;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dpTable = new Integer[n][n];
        return dp(triangle, 0, 0);
    }
    private int dp(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        int down = dp(triangle, row + 1, col);
        int downRight = dp(triangle, row + 1, col + 1);
        dpTable[row][col] = Math.min(down, downRight) + triangle.get(row).get(col);
        return dpTable[row][col];
    }
}