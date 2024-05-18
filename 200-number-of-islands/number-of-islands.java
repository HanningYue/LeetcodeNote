class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {        
                if (grid[row][col] == '1' && !visited[row][col]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});

                    while (!queue.isEmpty()) {
                        int[] currentOne = queue.poll();
                        int currentRow = currentOne[0], currentCol = currentOne[1];

                        for (int[] dir : directions) {
                            int nextRow = currentRow + dir[0], nextCol = currentCol + dir[1];
                            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n 
                            || visited[nextRow][nextCol] || grid[nextRow][nextCol] != '1') {
                                continue;
                            }

                            queue.offer(new int[]{nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}