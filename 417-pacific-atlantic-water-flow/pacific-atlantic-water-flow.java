class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            dfs(heights, Pacific, row, 0, result, Integer.MIN_VALUE);
            dfs(heights, Atlantic, row, n - 1, result, Integer.MIN_VALUE);
        }
        for (int col = 0; col < n; col++) {
            dfs(heights, Pacific, 0, col, result, Integer.MIN_VALUE);
            dfs(heights, Atlantic, m - 1, col, result, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int[][] heights, boolean[][] visited, int row, int col, 
    List<List<Integer>> result, int previousNum) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length 
        || visited[row][col] || heights[row][col] < previousNum) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(heights, visited, row + dir[0], col + dir[1], result, heights[row][col]);
        }
    }
}