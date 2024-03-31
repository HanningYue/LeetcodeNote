class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null | matrix.length == 0) return 0;
        
        dpTable = new Integer[matrix.length][matrix[0].length];
        int result = 1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, 
                dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        
        return result;
    }
    
    private int dfs(int[][] matrix, int row, int col, int prev){
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || prev >= matrix[row][col]) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int up = dfs(matrix, row - 1, col, matrix[row][col]) + 1;
        int down = dfs(matrix, row + 1, col, matrix[row][col]) + 1;
        int left = dfs(matrix, row, col - 1, matrix[row][col]) + 1;
        int right = dfs(matrix, row, col + 1, matrix[row][col]) + 1;
        
        dpTable[row][col] = Math.max(up, Math.max(down, Math.max(left, right)));
        return dpTable[row][col];
    }
}