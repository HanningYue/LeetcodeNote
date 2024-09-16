class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        word = "";
        isWord = false;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : words) {
            addWord(root, word);
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    dfs(board, row, col, root, result, visited);
                }
            }
        }
        return result;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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

    private void addWord(TrieNode root, String s) {
        for (char c : s.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.isWord = true;
        root.word = s;
    }
}