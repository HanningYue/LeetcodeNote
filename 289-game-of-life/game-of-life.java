class Solution {
    private int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, 
    {0, 1}, {1, 1}, {1, -1}, {1, 0}};

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    if (newRow >= m || newRow < 0 || newCol >= n 
                    || newCol < 0 || board[newRow][newCol] != 1) {
                        continue;
                    }
                    count++;
                }
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        result[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        result[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
}