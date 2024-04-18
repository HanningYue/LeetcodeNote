class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        word = "";
        isEnd = false;
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    TrieNode node = root;
                    dfs(board, row, col, result, node, visited);
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int row, int col, List<String> result, TrieNode node, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] 
        || node.children[board[row][col] - 'a'] == null) {
            return;
        }
        
        char c = board[row][col];
        if (node.children[c - 'a'].isEnd) {
            node.children[c - 'a'].isEnd = false;
            result.add(node.children[c - 'a'].word);
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], result, node.children[c - 'a'], visited);
        }
        visited[row][col] = false;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;
        node.isEnd = true;
    }
}