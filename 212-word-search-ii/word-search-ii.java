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
        for (String word : words) {
            insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (root.children[current - 'a'] != null) {
                    TrieNode node = root;
                    dfs(board, node, i, j, result, visited);
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, TrieNode node, int row, int col, List<String> result,
    boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
        || node.children[board[row][col] - 'a'] == null || visited[row][col]) {
            return;
        }

        char current = board[row][col];
        if (node.children[current - 'a'].isEnd) {
            result.add(node.children[current - 'a'].word);
            node.children[current - 'a'].isEnd = false;
        }
        
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(board, node.children[current - 'a'], row + dir[0], col + dir[1], result, visited);
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