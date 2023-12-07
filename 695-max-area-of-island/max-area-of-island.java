class Solution {
  public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
        }
      }
    }
    return maxArea;
  }
  private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length 
    || visited[i][j] || grid[i][j] == 0) {
      return 0;
    }
    int area = 1;
    visited[i][j] = true;
    area += dfs(grid, i + 1, j, visited);
    area += dfs(grid, i - 1, j, visited);
    area += dfs(grid, i, j + 1, visited);
    area += dfs(grid, i, j - 1, visited);
    return area;
  }
}