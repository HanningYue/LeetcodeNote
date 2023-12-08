/**
1.DFS,上下 左右 行列遍历. 往四个方向遍历，如果大于等于当前value，说明可以
2.两个ocean，pacific和atlantic。 如果都可以到达，加入最后的arraylist
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;
        boolean[][] Pacific = new boolean[rows][cols];
        boolean[][] Atlantic = new boolean[rows][cols];
    
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, heights[i][0], Pacific);
            dfs(heights, i, cols - 1, heights[i][cols - 1], Atlantic);
        }
        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, heights[0][i], Pacific);
            dfs(heights, rows - 1, i, heights[rows - 1][i], Atlantic);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, int row, int col, int previous, boolean[][] visited) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length 
        || heights[row][col] < previous || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], visited);
        dfs(heights, row - 1, col, heights[row][col], visited);
        dfs(heights, row, col + 1, heights[row][col], visited);
        dfs(heights, row, col - 1, heights[row][col], visited);
    }
}