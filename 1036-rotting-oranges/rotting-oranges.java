class State { 
    int x, y;
    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int countOfFresh = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<State> queue = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    countOfFresh++;
                }
                if (grid[row][col] == 2) {
                    queue.offer(new State(row, col));
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        while (!queue.isEmpty() && countOfFresh > 0) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                if (visited[current.x][current.y]) {
                    continue;
                }
                visited[current.x][current.y] = true;

                for (int[] dir : directions) {
                    int newX = dir[0] + current.x;
                    int newY = dir[1] + current.y;
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    if (grid[newX][newY] != 1) {
                        continue;
                    }
                    grid[newX][newY] = 2;
                    countOfFresh--;            
                    queue.offer(new State(newX, newY));
                }
            }
        }

        if (countOfFresh != 0) {
            return -1;
        }
        return time;
    }
}