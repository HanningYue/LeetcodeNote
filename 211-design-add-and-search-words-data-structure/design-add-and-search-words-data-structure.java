class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return searchDfs(word, node);
    }

    public boolean searchDfs(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchDfs(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */