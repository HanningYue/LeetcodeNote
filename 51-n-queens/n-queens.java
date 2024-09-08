class Solution {
    List<String> board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        result = new ArrayList<>();
        backTrack(0);
        return result;
    }
    private void backTrack(int row) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        StringBuilder sb = new StringBuilder(board.get(row));
        for (int col = 0; col < board.size(); col++) {
            if (valid(row, col)) {
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                backTrack(row + 1);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    private boolean valid(int row, int col) {
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