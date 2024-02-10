class NumMatrix {
    private int[][] prefixsum;
    public NumMatrix(int[][] matrix) {
        prefixsum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < prefixsum.length; i++) {
            for (int j = 1; j < prefixsum[0].length; j++) {
                prefixsum[i][j] = prefixsum[i - 1][j] + prefixsum[i][j - 1] + matrix[i - 1][j - 1] - prefixsum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixsum[row2 + 1][col2 + 1] - prefixsum[row2 + 1][col1] 
        - prefixsum[row1][col2 + 1] + prefixsum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */