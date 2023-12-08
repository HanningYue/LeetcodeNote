/** DFS
1. Create a boolean[] to mark the visited island
2. Two for loops go over the grid
3. Call dfs on the i + 1, j + 1, i - 1, j - 1
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != '0') {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] 
        || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}