class TrieNode {
    TrieNode[] children;
    String word;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            insert(root, word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    dfs(board, root, row, col, result, visited);
                }               
            }
        }
        return result;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, TrieNode node, int row, int col, List<String> result, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        char c = board[row][col];
        if (node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];
        if (node.isWord) {
            result.add(node.word);
            node.isWord = false;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, node, row + dir[0], col + dir[1], result, visited);
        }
        visited[row][col] = false;
    }

    private void insert(TrieNode node, String s) {
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
        node.word = s;
    }
}