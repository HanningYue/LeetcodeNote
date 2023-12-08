/**
1.BFS遍历, 最短时间
2.要先遍历一遍图，记录fresh的数量和fill out queue里的坏橙子
3.在BFS时，当条件符合时，才加入queue （和dfs 退出return条件刚好相反）
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && fresh != 0) {
            minute++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return fresh == 0 ? minute : -1;
    }
}