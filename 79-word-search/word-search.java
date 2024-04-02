class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, int row, int col, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            if (dfs(board, row + direction[0], col + direction[1], index + 1, word, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}