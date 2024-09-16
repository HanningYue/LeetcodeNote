class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);        
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return step;
                }

                for (int j = 1; j <= 6; j++) {
                    int nextStep = current + j;
                    if (nextStep > n * n) {
                        break;
                    }

                    int[] nextCell = oneDimension(nextStep, n);
                    if (visited[nextCell[0]][nextCell[1]]) {
                        continue;
                    }

                    visited[nextCell[0]][nextCell[1]] = true;
                    if (board[nextCell[0]][nextCell[1]] != -1) {
                        nextStep = board[nextCell[0]][nextCell[1]];
                    }
                    queue.offer(nextStep);
                }
            }
            step++;
        }
        return -1;
    }
    private int[] oneDimension(int index, int colLength) {
        int row = (index - 1) / colLength;
        int col = (index - 1) % colLength;

        int resultRow = colLength - row - 1;
        int resultCol = row % 2 == 0 ? col : colLength - col - 1;
        return new int[]{resultRow, resultCol};
    }
}