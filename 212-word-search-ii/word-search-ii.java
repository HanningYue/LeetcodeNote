class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    String word;
    public TrieNode() {
        word = "";
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Solution {
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            insert(word);
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    TrieNode node = root;
                    dfs(board, row, col, node, result, visited);
                }
            }
        }
        return result;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || node.children[board[row][col] - 'a'] == null || visited[row][col]) {
            return;
        }
    
        char c = board[row][col];
        if (node.children[c - 'a'].isEnd) {
            result.add(node.children[c - 'a'].word);
            node.children[c - 'a'].isEnd = false;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], node.children[c - 'a'], result, visited);
        }
        visited[row][col] = false;
    }

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
        node.word = s;
    }
}