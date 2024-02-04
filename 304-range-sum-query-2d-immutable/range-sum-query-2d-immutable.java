class NumMatrix {
    private int[][] presum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        presum = new int[m + 1][n + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                presum[i + 1][j + 1] 
                = presum[i][j + 1] + presum[i + 1][j] - presum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] 
        - presum[row2 + 1][col1] 
        - presum[row1][col2 + 1]
        + presum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */