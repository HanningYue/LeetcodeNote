class Solution {
    Integer[][] dpTable;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null | matrix.length == 0) return 0;
        
        dpTable = new Integer[matrix.length][matrix[0].length];
        int result = 1;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, 
                dfs(matrix, i, j, visited, Integer.MIN_VALUE));
            }
        }
        
        return result;
    }
    
    private int dfs(int[][] matrix, int row, int col, boolean[][] visited, int prev){
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || visited[row][col] || prev >= matrix[row][col]) {
            return 0;
        }
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        
        int up = dfs(matrix, row - 1, col, visited, matrix[row][col]) + 1;
        int down = dfs(matrix, row + 1, col, visited, matrix[row][col]) + 1;
        int left = dfs(matrix, row, col - 1, visited, matrix[row][col]) + 1;
        int right = dfs(matrix, row, col + 1, visited, matrix[row][col]) + 1;
        visited[row][col] = false;
        
        dpTable[row][col] = Math.max(up, Math.max(down, Math.max(left, right)));
        return dpTable[row][col];
    }
}