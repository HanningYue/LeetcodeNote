class Solution {
    Integer[][] dpTable;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];

        int maxSquareSide = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                maxSquareSide = Math.max(maxSquareSide, dp(matrix, row, col));
            }
        }
        
        return maxSquareSide * maxSquareSide;
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
        dpTable[row][col] = Math.min(left, Math.min(up, leftUp)) + 1;
        return dpTable[row][col];
    }
}