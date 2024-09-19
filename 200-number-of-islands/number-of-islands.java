class State {
    int row;
    int col;
    public State(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    Queue<State> queue = new ArrayDeque<>();
                    queue.offer(new State(row, col));

                    while (!queue.isEmpty()) {
                        State current = queue.poll();
                        int currentRow = current.row, currentCol = current.col;

                        for (int[] dir : directions) {
                            int newRow = currentRow + dir[0];
                            int newCol = currentCol + dir[1];
                            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                                continue;
                            }
                            if (visited[newRow][newCol] || grid[newRow][newCol] != '1') {
                                continue;
                            }
                            queue.offer(new State(newRow, newCol));
                            visited[newRow][newCol] = true;
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }
}