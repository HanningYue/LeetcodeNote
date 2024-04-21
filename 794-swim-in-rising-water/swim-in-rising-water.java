class Pair {
    int maxElevation;
    int row, col;
    public Pair(int row, int col, int maxElevation) {
        this.row = row;
        this.col = col;
        this.maxElevation = maxElevation;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.maxElevation - b.maxElevation;
            }
        });
        heap.offer(new Pair(0, 0, grid[0][0]));
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentmaxElevation = current.maxElevation;
            if (currentRow == m - 1 && currentCol == n - 1) {
                return currentmaxElevation;
            }

            visited[currentRow][currentCol] = true;
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                int newMaxElevation = Math.max(grid[newRow][newCol], currentmaxElevation);
                heap.offer(new Pair(newRow, newCol, newMaxElevation));
            }
        }
        return -1;
    }
}