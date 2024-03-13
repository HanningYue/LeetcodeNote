class Solution {
    int[][] dpTable;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new int[m][n];

        for (int i = 0; i < m; i++) {
            dpTable[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < n; j++) {
            dpTable[0][j] = matrix[0][j] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != '0') {
                    dpTable[i][j] 
                    = Math.min(dpTable[i - 1][j - 1], Math.min(dpTable[i - 1][j], dpTable[i][j - 1])) + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dpTable[i][j]);
            }
        }
        return result * result;
    }
}