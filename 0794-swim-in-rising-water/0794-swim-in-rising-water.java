/**
n x n grid, square
Goal is to find the LEAST time until reach grid(n - 1, n - 1)
1. The boundary between the minimum and maximum time is 0 to n * n - 1 (because 0 < grid[i][j] < n * n - 1) given*
2. If if we able to reach some point at 5th sec, then I can reach in 6,7,8... time also.
3. Idea is to use Binary Search to check at any T, if my answer is possible.
            -> If its possible in time T, check for less time than T
            -> If its not possible in time T, check for more time than T
4. Use DFS 岛屿问题 + binary search
*/
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lowTime = grid[0][0];
        int highTime = n * n - 1;
        
        while (lowTime < highTime) {
            int midTime = lowTime + (highTime - lowTime) / 2;
            boolean visited[][] = new boolean[grid.length][grid.length];
            if (dfs(grid, 0, 0, visited, midTime)) {
                highTime = midTime;
            } else {
                lowTime = midTime + 1;
            }
        }
        return lowTime;
    }
    private boolean dfs(int[][] grid, int row, int column, boolean visited[][], int time) {
        int n = grid.length;
        if (row < 0 || row >= n || column < 0 || column >= n || visited[row][column] || grid[row][column] > time) {
            return false;
        }
        visited[row][column] = true;
        if (row == n - 1 && column == n - 1) {
            return true;
        }

        return dfs(grid, row - 1, column, visited, time) ||
            dfs(grid, row + 1, column, visited, time) ||
            dfs(grid, row, column + 1, visited, time) ||
            dfs(grid, row, column - 1, visited, time);
    }
}