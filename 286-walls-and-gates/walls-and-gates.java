/**
BFS, same as rotten orange, but we add gate to queue
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] gate = queue.poll();
                for (int[] dir : dirs) {
                    int row = gate[0], col = gate[1];
                    int x = row + dir[0];
                    int y = col + dir[1];

                    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length 
                    || rooms[x][y] != Integer.MAX_VALUE || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    rooms[x][y] = rooms[row][col] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}