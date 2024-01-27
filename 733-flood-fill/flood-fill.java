class Solution {
    public int[][] floodFill(int[][] matrix, int sr, int sc, int color) {
        int startColor = matrix[sr][sc];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, sr, sc, startColor, visited, color);
        return matrix;
    }
    private void dfs(int[][] matrix, int row, int col, int startColor, boolean[][] visited, int color) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || matrix[row][col] != startColor || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        matrix[row][col] = color;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dfs(matrix, row + dir[0], col + dir[1], startColor, visited, color);
        }
    }
}