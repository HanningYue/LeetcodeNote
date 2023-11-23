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
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (backTracking(board, word, visited, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backTracking(char[][] board, String word, boolean[][] visited, int row,
    int column, int iteration)
    {
        if (iteration == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length 
        || board[row][column] != word.charAt(iteration) || visited[row][column]) 
        {
            return false;
        }

        visited[row][column] = true;
        boolean result = backTracking(board, word, visited, row + 1, column, iteration + 1)
        || backTracking(board, word, visited, row - 1, column, iteration + 1)
        || backTracking(board, word, visited, row, column + 1, iteration + 1)
        || backTracking(board, word, visited, row, column - 1, iteration + 1);
        visited[row][column] = false;
        return result;
    }
}