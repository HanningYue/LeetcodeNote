class State {
    int row, col, maxHeight;
    public State(int row, int col, int maxHeight) {
        this.row = row;
        this.col = col;
        this.maxHeight = maxHeight;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.maxHeight - b.maxHeight);
        heap.offer(new State(0, 0, grid[0][0]));

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!heap.isEmpty()) {
            int size = heap.size();
            for (int i = 0; i < size; i++) {
                State current = heap.poll();
                visited[current.row][current.col] = true;

                if (current.row == n - 1 && current.col == n - 1) {
                    return current.maxHeight;
                }

                for (int[] dir : directions) {
                    int newRow = dir[0] + current.row;
                    int newCol = dir[1] + current.col;
                    if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                        continue;
                    }
                    if (visited[newRow][newCol]) {
                        continue;
                    }

                    heap.offer(new State(newRow, newCol, Math.max(current.maxHeight, grid[newRow][newCol])));
                }
            }
        }
        return -1;
    }
}