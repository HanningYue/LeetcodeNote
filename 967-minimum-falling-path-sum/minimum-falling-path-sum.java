class Solution {
    private int[][] dpTable;
    public int minFallingPathSum(int[][] matrix) {    
        dpTable = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(dpTable[i], 66666);
        }
        int result = Integer.MAX_VALUE;
        for (int col = 0; col < matrix.length; col++) {
            result = Math.min(result, dp(matrix, matrix.length - 1, col));
        }
        return result;
    }
    private int dp(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 99999;
        }
        if (row == 0) {
            return matrix[0][col];
        }
        if (dpTable[row][col] != 66666) {
            return dpTable[row][col];
        }

        dpTable[row][col] = matrix[row][col] + 
        min(dp(matrix, row - 1, col), dp(matrix, row - 1, col - 1), dp(matrix, row - 1, col + 1));
        return dpTable[row][col];
    }
    private int min(int a, int b, int c) {
        return Math.min(Math.min(b, c), a);
    }
}