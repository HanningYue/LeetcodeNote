class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int count = dfs(grid, i, j, visited);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] 
        || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        int count = 1;
        for (int[] dir : directions) {
            count += dfs(grid, row + dir[0], col + dir[1], visited);
        }
        return count;
    }
}