class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char startChar = board[row][col];
                if (startChar == word.charAt(0)) {
                    if (dfs(board, visited, row, col, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, int index, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
        || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            if (dfs(board, visited, row + dir[0], col + dir[1], index + 1, word)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}