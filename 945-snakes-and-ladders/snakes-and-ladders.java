class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return steps;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    int[] nextCoor = squareToCoor(next, n);
                    if (next > n * n) {
                        break;
                    }

                    if (visited[nextCoor[0]][nextCoor[1]]) {
                        continue;
                    }
                    visited[nextCoor[0]][nextCoor[1]] = true;
                    if (board[nextCoor[0]][nextCoor[1]] != -1) {
                        next = board[nextCoor[0]][nextCoor[1]];
                    }
                    queue.offer(next);
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] squareToCoor(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        int row = n - 1 - r;
        int col = r % 2 == 0 ? c : n - 1 - c;
        return new int[]{row, col};
    }
}
