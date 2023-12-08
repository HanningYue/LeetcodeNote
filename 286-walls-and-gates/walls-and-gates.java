/**
BFS, same as rotting oranges
Want to fill each empty room with the nearest distance to any arbitrary gate
    Start with GATE, iterate the grid, add all the GATE int[]   
    Poll any gate int[]
    Declear four directions, with rows = gate[0] + direction[0]
    Check Boundaries and Whether the cell is an Empty Room
    If satisfied, skip the iteration
    If not satisfied, offer the new cell to Queue, mark the gate cell to be the previous cell + 1
    (rooms[x][y] = rooms[rows][columns] + 1)
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int rows = gate[0], columns = gate[1];
            for (int[] direction : directions) {
                int x = rows + direction[0], y = columns + direction[1];
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length 
                || rooms[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{x, y});
                rooms[x][y] = rooms[rows][columns] + 1;
            }
        }
    }
}