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
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.maxWater - b.maxWater;
            }
        });
        heap.offer(new Pair(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentMaxWater = current.maxWater;
            if (currentRow == grid.length - 1 && currentCol == grid[0].length - 1) {
                return currentMaxWater;
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
                || visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                int newMaxWater = Math.max(currentMaxWater, grid[newRow][newCol]);
                heap.offer(new Pair(newRow, newCol, newMaxWater));
            }
        }
        return -1;
    }
}