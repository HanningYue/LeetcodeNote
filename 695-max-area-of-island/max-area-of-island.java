class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result = Math.max(result, dfs(grid, visited, i, j));
                }
            }
        }
        return result;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
        || visited[row][col] || grid[row][col] != 1) {
            return 0;
        }
        visited[row][col] = true;
        
        int currentIslandArea = 1;
        for (int[] dir : directions) {
            currentIslandArea += dfs(grid, visited, row + dir[0], col + dir[1]);
        }
        return currentIslandArea;
    }
}