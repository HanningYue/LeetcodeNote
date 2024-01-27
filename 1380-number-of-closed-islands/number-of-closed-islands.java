class Solution {
    public int closedIsland(int[][] matrix) {
        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 0 && dfs(matrix, i, j, visited)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (matrix[row][col] == 1 || visited[row][col]) {
            return true;
        }
        if (row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[0].length - 1) {
            return false;
        }
        visited[row][col] = true;
        boolean isClosed = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            isClosed &= dfs(matrix, row + dir[0], col + dir[1], visited);
        }
        return isClosed;
    }
}