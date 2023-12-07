/**
BFS to trace the shortest Path(Time, in this manner)
Iterate the whole grid
    Apply Queue<int[]> to save the the location of the rotten orange, also mark the fresh orange number
Save the four directions as int[][], enter BFS, exit rule is !queue.isEmpty && fresh != 0
    Increase the minutes (desired result)
    Save row and column as rotten orange[0] and [1]
    Iterate the four directions of rotten orange, x = row + dir[0], y = column + dir[1]
    If inside the boundaries and encounter fresh orange, mark fresh orange as rotten, add new rotten 
    orange location as new[], minus fresh orange numbers
Return fresh == 0 ? minutes : -1 This means we have fresh orange that is untouchable
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        //BFS
        int minutes = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty() && fresh != 0) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] direction : directions) {
                    int x = rotten[0] + direction[0], y = rotten[1] + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}