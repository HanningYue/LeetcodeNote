class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            dfs(heights, pacific, row, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, row, n - 1, Integer.MIN_VALUE);
        }
        for (int col = 0; col < n; col++) {
            dfs(heights, pacific, 0, col, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, col, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int[][] heights, boolean[][] ocean, int row, int col, int prev) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || ocean[row][col]) {
            return;
        }
        if (heights[row][col] < prev) {
            return;
        }

        ocean[row][col] = true;
        for (int[] dir : directions) {
            dfs(heights, ocean, row + dir[0], col + dir[1], heights[row][col]);
        }
    }
}