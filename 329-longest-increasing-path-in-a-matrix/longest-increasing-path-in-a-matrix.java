class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dpTable = new Integer[m][n];
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result = Math.max(result, dfs(matrix, row, col, -1));
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dfs(int[][] matrix, int row, int col, int previousValue) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || previousValue >= matrix[row][col]) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }

        int count = 1;
        for (int[] dir : directions) {
            int goFourDirectional = dfs(matrix, row + dir[0], col + dir[1], matrix[row][col]);
            count = Math.max(count, goFourDirectional + 1);
        }
        dpTable[row][col] = count;
        return dpTable[row][col];
    }
}
