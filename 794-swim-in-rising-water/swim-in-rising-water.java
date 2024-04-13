class Pair {
    int row, col, maxWater;
    public Pair(int row, int col, int maxWater) {
        this.row = row;
        this.col = col;
        this.maxWater = maxWater;
    }
}
class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.maxWater - b.maxWater;
            }
        });
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        heap.offer(new Pair(0, 0, grid[0][0]));
        visited[0][0] = true;

        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentMaxWater = current.maxWater;
            visited[currentRow][currentCol] = true;
            if (currentRow == m - 1 && currentCol == n - 1) {
                return currentMaxWater;
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
                || visited[newRow][newCol]) {
                    continue;
                }

                int newMaxWater = Math.max(currentMaxWater, grid[newRow][newCol]);
                heap.offer(new Pair(newRow, newCol, newMaxWater));
            }
        }
        return -1;
    }
}