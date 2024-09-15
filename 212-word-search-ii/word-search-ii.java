class TrieNode {
    boolean isWord;
    String word;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            addWord(word, root);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    backTrack(board, words, root, row, col, visited, result);
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void backTrack(char[][] board, String[] words, TrieNode node, int row, int col, 
    boolean[][] visited, List<String >result) {
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
            backTrack(board, words, node, row + dir[0], col + dir[1], visited, result);
        }
        visited[row][col] = false;
    }

    private void addWord(String word, TrieNode root) {
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