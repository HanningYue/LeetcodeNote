class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return count;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
        || visited[row][col] || grid[row][col] != '1') {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited);
        }
    }
}