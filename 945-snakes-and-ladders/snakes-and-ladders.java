class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;

        int step = 0;
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

                    int[] nextCoor = numToCoor(next, n);
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
            step++;
        }
        return -1;
    }
    private int[] numToCoor(int num, int colLength) {
        int r = (num - 1) / colLength;
        int c = (num - 1) % colLength;
        int row = colLength - r - 1;
        int col = r % 2 == 0 ? c : colLength - c - 1;
        return new int[]{row, col};
    }
}