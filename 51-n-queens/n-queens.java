class Solution {
    List<List<String>> result;
    List<String> board;
    public List<List<String>> solveNQueens(int n) {
        board = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backTrack(0);
        return result;
    }
    private void backTrack(int row) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < board.get(row).length(); col++) {
            if (isValid(row, col)) {
                StringBuilder currentRow = new StringBuilder(board.get(row));
                currentRow.setCharAt(col, 'Q');
                board.set(row, currentRow.toString());
                backTrack(row + 1);
                currentRow.setCharAt(col, '.');
                board.set(row, currentRow.toString());
            }
        }
    }
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}