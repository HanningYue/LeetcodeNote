class TrieNode {
    String word;
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
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
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
        node.word = word;
    }
    public boolean search(String word) {
        return recursionSearch(word, root);
    }
    private boolean recursionSearch(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : root.children) {
                    if (child != null && recursionSearch(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
        }
        return root.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */