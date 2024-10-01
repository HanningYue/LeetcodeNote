class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, row, col, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
    
        visited[row][col] = true;
        for (int[] dir : directions) {
            if (dfs(board, row + dir[0], col + dir[1], word, index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}