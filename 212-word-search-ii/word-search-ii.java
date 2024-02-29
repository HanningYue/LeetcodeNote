class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    String word = "";
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
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

        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    TrieNode current = root;
                    dfs(board, i, j, current, result, visited);
                }
            }
        }
        return result;
    }
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int row, int col, TrieNode root, 
    List<String> result, boolean[][] visited) 
    {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        char c = board[row][col];
        if (root.children[c - 'a'] == null) {
            return;
        }
        if (root.children[c - 'a'].isEnd) {
            result.add(root.children[c - 'a'].word);
            root.children[c - 'a'].isEnd = false;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], root.children[c - 'a'], result, visited);
        }
        visited[row][col] = false;
    }
    private void insert(String word) {
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