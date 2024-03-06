class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        return dfs(word, current);
    }
    private boolean dfs(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : root.children) {
                    if (child != null && dfs(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
        }
        return root.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */