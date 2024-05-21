class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int countLive = 0;
                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n 
                    || board[newRow][newCol] == 0 || board[newRow][newCol] == 3) {
                        continue;
                    }
                    countLive++;
                }
                
                if (board[row][col] == 1) {
                    if (countLive < 2 || countLive > 3) {
                        board[row][col] = 2;
                    }
                } else if (board[row][col] == 0) {
                    if (countLive == 3) {
                        board[row][col] = 3;
                    }
                }
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = board[row][col] % 2;
            }
        }
    }
}