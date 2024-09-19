class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    result++;
                    dfs(row, col, grid, visited);
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (visited[row][col] || grid[row][col] != '1') {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid, visited);
        }
    }
}