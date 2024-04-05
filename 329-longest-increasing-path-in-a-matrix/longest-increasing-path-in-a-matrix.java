class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];
        
        int prev = Integer.MIN_VALUE;
        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, prev));
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int dfs(int[][] matrix, int row, int col, int prev) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || matrix[row][col] <= prev) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }

        int current = 1;
        for (int[] dir : directions) {
            current = Math.max(current, dfs(matrix, row + dir[0], col + dir[1], matrix[row][col]) + 1);
        }
        dpTable[row][col] = current;
        return current;
    }
}