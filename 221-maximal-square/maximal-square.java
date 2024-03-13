/**
dp 数组：以 matrix[i][j] 为右下角元素的最大的全为 1 正方形矩阵的边长为 dp[i][j]
水桶效应 所以找min
*/
class Solution {
    Integer[][] dpTable;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];
        
        int maxSide = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                maxSide = Math.max(maxSide, findMaxSquare(matrix, row, col));
            }
        }
        return maxSide * maxSide; // Return area
    }

    private int findMaxSquare(char[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || matrix[row][col] == '0') {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int up = findMaxSquare(matrix, row - 1, col);
        int left = findMaxSquare(matrix, row, col - 1);
        int leftUp = findMaxSquare(matrix, row - 1, col - 1);
        
        dpTable[row][col] = Math.min(Math.min(up, left), leftUp) + 1;
        return dpTable[row][col];
    }
}
