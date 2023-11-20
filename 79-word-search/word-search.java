/*
Exit rule, when index reach word's final index, return true;
We want to return a boolean value to determine whether the given word exists
We can apply DFS given the circumstances, iterate 4 directional, if character at the 
board[row][column] DOES NOT equals to the character at the given index in WORD, we return false;
for each dfs iteration, we need to mark current board[row][column] as visited,
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int index, int row, int column) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length 
            || visited[row][column] || board[row][column] != word.charAt(index)) 
        {
            return false;
        }
        visited[row][column] = true;
        boolean result = dfs(board, word, visited, index + 1, row + 1, column) 
        || dfs(board, word, visited, index + 1, row - 1, column) 
        || dfs(board, word, visited, index + 1, row, column + 1) 
        || dfs(board, word, visited, index + 1, row, column - 1);
        visited[row][column] = false;
        return result;
    }
}