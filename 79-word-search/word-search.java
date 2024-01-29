class Solution {
    public boolean exist(char[][] matrix, String word) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (backTrack(matrix, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backTrack(char[][] matrix, String word, int row, int col, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
        || visited[row][col] || matrix[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        boolean result = false;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            result = result || backTrack(matrix, word, row + dir[0], col + dir[1], visited, index + 1);
        }
        visited[row][col] = false;

        return result;
    }
}