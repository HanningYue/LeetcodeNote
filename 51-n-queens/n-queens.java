class Solution {
    int n;
    List<List<String>> result;
    List<String> board;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        result = new ArrayList<>();
        board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            board.add(row.toString());
        }
        backTrack(0);
        return result;
    }

    private void backTrack(int row) {
        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        StringBuilder currentRow = new StringBuilder(board.get(row));
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
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
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}