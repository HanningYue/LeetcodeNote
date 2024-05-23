class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, row, col, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
        || visited[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
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