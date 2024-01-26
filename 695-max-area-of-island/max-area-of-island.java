class Solution {
    public int maxAreaOfIsland(int[][] matrix) {
        int area = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    area = Math.max(area, bfs(matrix, visited, i, j));
                }
            }
        }        
        return area;
    }
    private int bfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length 
                || matrix[newRow][newCol] != 1 || visited[newRow][newCol]) {
                    continue;
                }
                area++;
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return area;
    }
}