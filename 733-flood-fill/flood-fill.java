class Solution {
  public int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int originalColor = matrix[x][y];
    dfs(matrix, x, y, newColor, visited, originalColor);
    return matrix;
  }
  private void dfs(int[][] matrix, int x, int y, int newColor, boolean[][] visited, int originalColor) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
    || matrix[x][y] != originalColor || visited[x][y]) {
      return;
    }
    matrix[x][y] = newColor;
    visited[x][y] = true;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : directions) {
      dfs(matrix, x + dir[0], y + dir[1], newColor, visited, originalColor);
    }
  }
}
