class Solution {
    Integer[][] dpTable;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];
        
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                side = Math.max(side, dp(matrix, i, j));
            }
        }
        return side * side;
    }
    private int dp(char[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || matrix[row][col] != '1') {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        int left = dp(matrix, row, col - 1);
        int up = dp(matrix, row - 1, col);
        int leftUp = dp(matrix, row - 1, col - 1);
        dpTable[row][col] = Math.min(leftUp, Math.min(left, up)) + 1;
        return dpTable[row][col];
    }
}