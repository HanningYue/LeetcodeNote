class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null | matrix.length == 0) return 0;
        dpTable = new Integer[matrix.length][matrix[0].length];
        
        int result = 1;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                result = Math.max(result, dfs(matrix, row, col, Integer.MIN_VALUE));
            }
        }
        return result;
    }
    
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int dfs(int[][] matrix, int row, int col, int prev) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
            || prev >= matrix[row][col]) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }

        int tempResult = 0;
        for (int[] dir : directions) {
            tempResult = Math.max(tempResult, 
            dfs(matrix, row + dir[0], col + dir[1], matrix[row][col]) + 1);
        }

        dpTable[row][col] = tempResult;
        return tempResult;
    }
}