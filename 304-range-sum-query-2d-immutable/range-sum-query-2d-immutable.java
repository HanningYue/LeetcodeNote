class NumMatrix {
    private int[][] presum;
    public NumMatrix(int[][] matrix) {
        presum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < presum.length; i++) {
            for (int j = 1; j < presum[0].length; j++) {
                presum[i][j] = matrix[i - 1][j - 1] + presum[i][j - 1] + presum[i - 1][j] - presum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
    }
}