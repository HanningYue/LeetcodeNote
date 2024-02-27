class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        reverseBoard(board);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current[0] + i;
                int[] nextCoor = squareToCoor(next, n);
                if (board[nextCoor[0]][nextCoor[1]] != -1) {
                    next = board[nextCoor[0]][nextCoor[1]];
                }

                if (next == n * n) {
                    return current[1] + 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, current[1] + 1});
                }
            }
        }
        return -1;
    }
    private int[] squareToCoor(int square, int boardLength) {
        int row = (square - 1) / boardLength;
        int col = (square - 1) % boardLength;
        if (row % 2 != 0) {
            col = boardLength - 1 - col;
        }
        return new int[]{row, col};
    }
    private void reverseBoard(int[][] board) {
        int left = 0, right = board.length - 1;
        while (left < right) {
            int[] temp = board[left];
            board[left] = board[right];
            board[right] = temp;
            left++;
            right--;
        }
    }
}