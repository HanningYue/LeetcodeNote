class TrieNode {
    String word;
    boolean isWord;
    TrieNode[] children;
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
            addWord(word, root);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    backTrack(board, i, j, root, result, visited);
                }
            }
        }   
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void backTrack(char[][] board, int row, int col, TrieNode node, List<String> result, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        if (node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];
        if (node.isWord) {
            node.isWord = false;
            result.add(node.word);
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            backTrack(board, row + dir[0], col + dir[1], node, result, visited);
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