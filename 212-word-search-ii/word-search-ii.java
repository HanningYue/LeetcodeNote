class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
        word = "";
    }
}
class Solution {
    TrieNode root;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (String word : words) {
            insert(word);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    TrieNode current = root;
                    dfs(board, result, i, j, current, visited);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] board, List<String> result, int row, int col, TrieNode current, 
    boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
        || visited[row][col]) {
            return;
        }
        char c = board[row][col];
        if (current.children[c - 'a'] == null) {
            return;
        }
        if (current.children[c - 'a'].isEnd) {
            result.add(current.children[c - 'a'].word);
            current.children[c - 'a'].isEnd = false;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, result, row + dir[0], col + dir[1], current.children[c - 'a'], visited);
        }
        visited[row][col] = false;
    }
    private void insert(String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
        current.word = s;
    }
}