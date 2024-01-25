class Solution {
    public int numIslands(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == '1') {
                    count++;
                    bfs(matrix, i, j, visited);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] matrix, int row, int col, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : direction) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length
                || matrix[newRow][newCol] != '1' || visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}