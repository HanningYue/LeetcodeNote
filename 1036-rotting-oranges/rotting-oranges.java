class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshOrange++;
                }
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int min = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && freshOrange != 0) {
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                int[] currentRotten = queue.poll();
                int currentRow = currentRotten[0], currentCol = currentRotten[1];
                visited[currentRow][currentCol] = true;

                for (int[] dir : directions) {
                    int newRow = currentRow + dir[0], newCol = currentCol + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n 
                    || visited[newRow][newCol] || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    freshOrange--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        if (freshOrange > 0) {
            return -1;
        }
        return min;
    }
}