class Solution {
    public int islandPerimeter(int[][] matrix) {
        int result = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    return dfs(matrix, i, j, visited);
                }
            }
        }
        return -1;
    }
    private int dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0) {
            return 1;
        }
        if (visited[row][col]) {
            return 0;
        }
        int perimeter = 0;
        visited[row][col] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            perimeter += dfs(matrix, row + dir[0], col + dir[1], visited);
        }
        return perimeter;
    }
}