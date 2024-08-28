class Solution {
    Integer[][] dpTable;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dpTable = new Integer[m][n];
        
        int maxSide = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                maxSide = Math.max(maxSide, dp(matrix, row, col));
            }
        }
 
        return maxSide * maxSide;
    }
    private int dp(char[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || matrix[row][col] != '1') {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int moveLeft = dp(matrix, row, col - 1);
        int moveUp = dp(matrix, row - 1, col);
        int moveUpLeft = dp(matrix, row - 1, col - 1);
        dpTable[row][col] = Math.min(moveLeft, Math.min(moveUp, moveUpLeft)) + 1;
        return dpTable[row][col];
    }
}