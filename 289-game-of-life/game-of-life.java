class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int m = board.length, n = board[0].length;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int count = 0;
                for (int[] dir : directions) {
                    int newRow = dir[0] + row;
                    int newCol = dir[1] + col;
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || board[newRow][newCol] == 0 || board[newRow][newCol] == 3) {
                        continue;
                    }
                    count++;
                }

                if (board[row][col] == 0) {
                    if (count == 3) {
                        board[row][col] = 3;
                    } else {
                        board[row][col] = 0;
                    }
                }

                if (board[row][col] == 1) {
                    if (count == 2 || count == 3) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 2;
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