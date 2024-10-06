class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] 
        || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited);
        }
    }
}