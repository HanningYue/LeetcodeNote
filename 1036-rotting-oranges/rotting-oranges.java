class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minute = 0;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]
                    || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    visited[newRow][newCol] = true;
                    fresh--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            minute++;
        }
        if (fresh != 0) {
            return -1;
        }
        return minute;
    }
}