class State {
    int x, y;
    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<State> queue = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new State(row, col));
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int step = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                
                for (int[] dir : directions) {
                    int newX = dir[0] + current.x;
                    int newY = dir[1] + current.y;
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                        continue;
                    }
                    if (rooms[newX][newY] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[newX][newY] = step;
                    visited[newX][newY] = true;
                    queue.offer(new State(newX, newY));
                }
            }
        }
    }
}
