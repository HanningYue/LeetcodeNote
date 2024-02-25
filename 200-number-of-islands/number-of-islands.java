class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count++;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] dir : directions) {
                            int newRow = current[0] + dir[0]; 
                            int newCol = current[1] + dir[1];
                            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                                queue.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}