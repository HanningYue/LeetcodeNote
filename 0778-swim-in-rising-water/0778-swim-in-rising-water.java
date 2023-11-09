/**
Binary Search + First DFS
n x n grid, square, GIVEN 0 <= grid[i][j] < n^2
Goal is to find the LEAST time until reach grid(n - 1, n - 1)
1. The boundary between the minimum and maximum time is 0 to n^2 - 1 (because 0 < grid[i][j] < n^2) and we start at 0

2. If if we able to reach some point at 5th sec, then I can reach in 6,7,8... time also.
3. Idea is to use Binary Search to check at any Time, if answer is possible.
            -> If its possible in time T, check for less time than T
            -> If its not possible in time T, check for more time than T
4. Use DFS 岛屿问题 + binary search 左边界，因为是return minimum time
*/
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lowTime = grid[0][0];
        int highTime = n * n - 1;
        
        while (lowTime < highTime) {
            int midTime = lowTime + (highTime - lowTime) / 2;
            boolean[][] visited = new boolean[n][n];
            if (dfs(grid, visited, midTime, 0, 0)) {
                highTime = midTime;
            } else {
                lowTime = midTime + 1;
            }
        }
        return lowTime;
    }
    private boolean dfs(int[][] grid, boolean[][] visited, int time, int row, int column) {
        int n = grid.length;
        if (row < 0 || row >= n || column < 0 || column >= n 
            || visited[row][column] || time < grid[row][column])
        {
            return false;
        }
        visited[row][column] = true;
        if (row == n - 1 && column == n - 1) {
            return true;
        }
        return dfs(grid, visited, time, row + 1, column)
            || dfs(grid, visited, time, row - 1, column)
            || dfs(grid, visited, time, row, column + 1)
            || dfs(grid, visited, time, row, column - 1); 
    }
}