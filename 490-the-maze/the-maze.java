class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
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
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            while (canMove(maze, x + dir[0], y + dir[1])) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(maze, new int[]{x, y}, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean canMove(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }
}
