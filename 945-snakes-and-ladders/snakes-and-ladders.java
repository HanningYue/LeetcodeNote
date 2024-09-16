class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;

        int step = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return step;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > n * n) {
                        break;
                    }

                    int[] nextCell = oneDimension(next, n);
                    int nextRow = nextCell[0], nextCol = nextCell[1];
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    if (board[nextRow][nextCol] != -1) {
                        next = board[nextRow][nextCol];
                    }
                    visited[nextRow][nextCol] = true;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
    private int[] oneDimension(int index, int n) {
        int row = (index - 1) / n;
        int col = (index - 1) % n;

        int resultRow = n - row - 1;
        int resultCol = row % 2 == 0 ? col : n - col - 1;
        return new int[]{resultRow, resultCol};
    }
}