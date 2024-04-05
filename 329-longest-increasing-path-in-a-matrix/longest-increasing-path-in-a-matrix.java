class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];

        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return result;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dfs(int[][] matrix, int row, int col, int prev) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || prev >= matrix[row][col]) 
        {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        int currentLongest = 0;
        for (int[] dir : directions) {
            currentLongest = Math.max(currentLongest,
            dfs(matrix, row + dir[0], col + dir[1], matrix[row][col]) + 1);
        }
        dpTable[row][col] = currentLongest;
        return dpTable[row][col];
    }
}