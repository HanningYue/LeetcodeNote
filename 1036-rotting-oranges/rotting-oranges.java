class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            } 
        }

        int step = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : dirs) {
                    int row = rotten[0], col = rotten[1];
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length 
                    || grid[newRow][newCol] != 1 || visited[newRow][newCol]) {
                        continue;
                    }
                    
                    grid[newRow][newCol] = 2;
                    visited[newRow][newCol] = true;
                    fresh--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return fresh == 0 ? step : -1;
    }
}