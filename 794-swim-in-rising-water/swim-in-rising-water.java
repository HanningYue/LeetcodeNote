class State {
    int row;
    int col;
    int maxHeight;
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

        PriorityQueue<State> heap = new PriorityQueue<>(new Comparator<State>() {
            public int compare(State a, State b) {
                return a.maxHeight - b.maxHeight;
            }
        });
        heap.offer(new State(0, 0, grid[0][0]));

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!heap.isEmpty()) {
            int size = heap.size();
            for (int i = 0; i < size; i++) {
                State current = heap.poll();

                if (current.row == n - 1 && current.col == n - 1) {
                    return current.maxHeight;
                }
                visited[current.row][current.col] = true;

                for (int[] dir : directions) {
                    int newRow = dir[0] + current.row;
                    int newCol = dir[1] + current.col;
                    if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                        continue;
                    }
                    if (visited[newRow][newCol]) {
                        continue;
                    }
                    int newHeight = grid[newRow][newCol];
                    heap.offer(new State(newRow, newCol, Math.max(current.maxHeight, newHeight)));
                }
            }
        }
        return -1;
    }
}
