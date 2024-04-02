class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
        word = "";
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];
                if (root.children[current - 'a'] != null) {
                    TrieNode node = root;
                    dfs(board, i, j, visited, node, result);
                }
            }
        }
        
        return result;
    }
    
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(char[][] board, int row, int col, boolean[][] visited, TrieNode node, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
        || node.children[board[row][col] - 'a'] == null) {
            return;
        }

        char current = board[row][col];
        if (node.children[current - 'a'].isEnd) {
            result.add(node.children[current - 'a'].word);
            node.children[current - 'a'].isEnd = false;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1], visited, node.children[current - 'a'], result);
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