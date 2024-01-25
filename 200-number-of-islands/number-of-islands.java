class Solution {
    public int numIslands(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == '1') {
                    count++;
                    dfs(matrix, i, j, visited);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] matrix, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || visited[row][col] || matrix[row][col] != '1') {
            return;
        }
        visited[row][col] = true;
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : direction) {
            dfs(matrix, row + dir[0], col + dir[1], visited);
        }
    }
}