class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, int row, int col, String word, int stringIdx, boolean[][] visited) {
        if (stringIdx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
        || board[row][col] != word.charAt(stringIdx)) {
            return false;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            if (dfs(board, row + dir[0], col + dir[1], word, stringIdx + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}