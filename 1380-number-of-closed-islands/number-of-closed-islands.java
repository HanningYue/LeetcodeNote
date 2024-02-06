class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0 && dfs(grid, i, j, visited)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if ((grid[row][col] == 0) && (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1)) {
            return false;
        }
        if (grid[row][col] == 1 || visited[row][col]) {
            return true;
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean closed = true;
        visited[row][col] = true;
        for (int[] dir : directions) {
            closed &= dfs(grid, row + dir[0], col + dir[1], visited);
        }
        return closed;
    }
}