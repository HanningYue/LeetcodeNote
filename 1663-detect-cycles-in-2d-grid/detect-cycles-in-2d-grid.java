class Solution {
    public boolean containsCycle(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && dfs(matrix, i, j, visited, -1, -1, matrix[i][j])) {
                    return true;
                }
            }
        }        
        return false;
    }
    private boolean dfs(char[][] matrix, int row, int col, boolean[][] visited, int prevx, int prevy, char startChar) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || matrix[row][col] != startChar) {
            return false;
        }
        if (visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            if (row + dir[0] != prevx || col + dir[1] != prevy) {
                if (dfs(matrix, row + dir[0], col + dir[1], visited, row, col, startChar)) {
                    return true;
                }
            }
        }
        return false;
    }
}