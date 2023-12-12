class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int row = start[0], col = start[1];
            while (canMove(maze, row + dir[0], col + dir[1])) {
                row += dir[0];
                col += dir[1];
            }
            if (dfs(maze, new int[]{row, col}, destination, visited)) {
                return true;
            }
        }
        return false;
    }
    private boolean canMove(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] != 0) {
            return false;
        }
        return true;
    }
}