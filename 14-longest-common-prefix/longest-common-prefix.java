class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String s : strs) {
            if (s.isEmpty()) {
                return "";
            }
            trie.insert(s);
        }
        return trie.longestPrefix();
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    public String longestPrefix() {
        StringBuilder prefix = new StringBuilder();

        TrieNode node = root;
        while (countChildren(node) == 1 && !node.isEnd) {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    prefix.append((char)('a' + i));
                    node = node.children[i];
                    break;
                }
            }
        }
        return prefix.toString();
    }
    public int countChildren(TrieNode node) {
        int count = 0;
        for (TrieNode child : node.children) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }
}