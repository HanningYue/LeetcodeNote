class Solution {
    public int closedIsland(int[][] matrix) {
        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    if (dfs(matrix, i, j, visited)) {
                        count++;
                    }
                }
            }
        }    
        return count;
    }

    private boolean dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (matrix[row][col] == 1 || visited[row][col]) {
            return true;
        }
        if (onEdge(matrix, row, col)) {
            return false;
        }

        visited[row][col] = true;
        boolean isClosed = true;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            isClosed &= dfs(matrix, row + dir[0], col + dir[1], visited);
        }
        return isClosed;
    }

    private boolean onEdge(int[][] matrix, int row, int col) {
        return row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[0].length - 1;
    }
}