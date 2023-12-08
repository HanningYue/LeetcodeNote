/**
1.DFS,上下 左右 行列遍历. 往四个方向遍历，如果大于等于当前value，说明可以
2.两个ocean，pacific和atlantic。 如果都可以到达，加入最后的arraylist
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;
        boolean[][] Pacific = new boolean[heights.length][heights[0].length];
        boolean[][] Atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < rows; i++) {
            dfs(heights, Pacific, i, 0, heights[i][0]);
            dfs(heights, Atlantic, i, cols - 1, heights[i][cols - 1]);
        }
        for (int i = 0; i < cols; i++) {
            dfs(heights, Pacific, 0, i, heights[0][i]);
            dfs(heights, Atlantic, rows - 1, i, heights[rows - 1][i]);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights, boolean[][] visited, int row, int col, int previous) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length 
        || visited[row][col] || heights[row][col] < previous) {
            return;
        }
        visited[row][col] = true;
        dfs(heights, visited, row + 1, col, heights[row][col]);
        dfs(heights, visited, row - 1, col, heights[row][col]);
        dfs(heights, visited, row, col + 1, heights[row][col]);
        dfs(heights, visited, row, col - 1, heights[row][col]);
    }
}