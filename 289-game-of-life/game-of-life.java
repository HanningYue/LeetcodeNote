class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, 0}, {1, -1}, {0, 1}, {1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int[] dir : directions) {
                    int newRow = dir[0] + i;
                    int newCol = dir[1] + j;
                    if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                    && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2))
                    {
                        count++;
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                }
                else if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}