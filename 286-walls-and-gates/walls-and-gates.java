class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>(); //save each gate
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] gate = queue.poll();
                for (int[] dir : directions) {
                    int row = gate[0], col = gate[1];
                    int newRow = gate[0] + dir[0], newCol = gate[1] + dir[1];
                    if (newRow < 0 || newRow >= rooms.length || newCol < 0 || newCol >= rooms[0].length 
                    || rooms[newRow][newCol] != Integer.MAX_VALUE || visited[newRow][newCol]) {
                        continue;
                    }

                    visited[newRow][newCol] = true;
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}