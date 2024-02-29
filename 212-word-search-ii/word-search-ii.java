class TrieNode {
    String word = "";
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];
    public TrieNode() {
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    TrieNode current = root;
                    dfs(result, i, j, current, board);
                }
            }
        }
        return result;
    }
    public int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(List<String> result, int row, int col, TrieNode root, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if (c == '#') {
            return;
        }
        if (root.children[c - 'a'] == null) {
            return;
        }

        if (root.children[c - 'a'].isEnd) {
            result.add(root.children[c - 'a'].word);
            root.children[c - 'a'].isEnd = false;
        }

        board[row][col] = '#';
        for (int[] dir : directions) {
            dfs(result, row + dir[0], col + dir[1], root.children[c - 'a'], board);
        }
        board[row][col] = c;
    }
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
        current.word = word;
    }
}