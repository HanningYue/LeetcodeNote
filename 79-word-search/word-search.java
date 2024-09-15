class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (backTrack(board, word, i, j, 0, visited)) {
                    return true;
                }                
            }
        }
        return false;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean backTrack(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
        || board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            if (backTrack(board, word, row + dir[0], col + dir[1], index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}