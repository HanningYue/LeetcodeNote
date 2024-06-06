class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentGate = queue.poll();
                int currentRow = currentGate[0], currentCol = currentGate[1];
                visited[currentRow][currentCol] = true;

                for (int[] dir : directions) {
                    int newRow = currentRow + dir[0], newCol = currentCol + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n 
                    || rooms[newRow][newCol] != Integer.MAX_VALUE || visited[newRow][newCol]) {
                        continue;
                    }
                    rooms[newRow][newCol] = rooms[currentRow][currentCol] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}