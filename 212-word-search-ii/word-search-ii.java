class TrieNode {
    boolean isEnd;
    String word;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
        word = "";
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

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    TrieNode node = root;
                    backTrack(board, i, j, visited, node, result);
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void backTrack(char[][] board, int row, int col, boolean[][] visited, TrieNode node, List<String> result) {
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
            backTrack(board, row + dir[0], col + dir[1], visited, node.children[c - 'a'], result);
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
        node.isEnd = true;
        node.word = word;
    }
}