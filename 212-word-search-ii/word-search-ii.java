class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}
class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            insert(word, root);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    dfs(board, row, col, root, result, visited);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode root, List<String> result, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        if (root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if (root.isWord) {
            root.isWord = false;
            result.add(root.word);
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], root, result, visited);
        }
        visited[row][col] = false;
    }

    private void insert(String word, TrieNode root) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.isWord = true;
        root.word = word;
    }
}
