class Pair {
    int row, col, maxWater;
    public Pair(int row, int col, int maxWater) {
        this.row = row;
        this.col = col;
        this.maxWater = maxWater;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.maxWater - b.maxWater;
            }
        });
        heap.offer(new Pair(0, 0, grid[0][0]));

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!heap.isEmpty()) {
            Pair currentCell = heap.poll();
            int currentRow = currentCell.row;
            int currentCol = currentCell.col;
            int currentMaxWater = currentCell.maxWater;
            if (currentRow == m - 1 && currentCol == n - 1) {
                return currentMaxWater;
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0], newCol = currentCol + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                int newMaxWater = Math.max(currentMaxWater, grid[newRow][newCol]);
                visited[newRow][newCol] = true;
                Pair newCell = new Pair(newRow, newCol, newMaxWater);
                heap.offer(newCell);
            } 
        }
        return -1;
    }
}