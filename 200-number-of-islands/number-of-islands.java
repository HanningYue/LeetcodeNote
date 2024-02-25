class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true; // Mark as visited when adding to queue
                    count++;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int row = current[0], col = current[1];
                        
                        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        for (int[] dir : directions) {
                            int newRow = row + dir[0], newCol = col + dir[1];
                            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                                && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                                queue.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true; // Correctly mark the new cell as visited
                            }
                        }
                    }

                }
            }
        }
        
        return count;
    }
}
