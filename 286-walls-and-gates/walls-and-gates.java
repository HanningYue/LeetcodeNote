class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        boolean[][] visited = new boolean[m][n];

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] gate = queue.poll();
                int row = gate[0];
                int col = gate[1];
                visited[row][col] = true;

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]
                    || rooms[newRow][newCol] != Integer.MAX_VALUE) {
                        continue;
                    }

                    queue.offer(new int[]{newRow, newCol});
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                }
            }
        }
    }
}