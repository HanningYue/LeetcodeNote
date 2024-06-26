class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] reach = new int[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];
        int totalBuildings = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, reach, distance);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void bfs(int[][] grid, int row, int col, int[][] reach, int[][] distance) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentBuilding = queue.poll();
                for (int[] dir : directions) {
                    int oldRow = currentBuilding[0], oldCol = currentBuilding[1];
                    int newRow = oldRow + dir[0], newCol = oldCol + dir[1];
                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
                    || visited[newRow][newCol] || grid[newRow][newCol] != 0) {
                        continue;
                    }

                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    reach[newRow][newCol]++;
                    distance[newRow][newCol] += step;
                }
            }
            step++;
        }
    }
}