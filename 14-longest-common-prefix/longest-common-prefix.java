class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
    
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.isEmpty()) {
                return "";  // If any string is empty, there's no common prefix
            }
            trie.insert(str);
        }
        
        return trie.longestCommonPrefix();
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

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        
        TrieNode node = root;
        while (countChildren(node) == 1 && !node.isEnd) {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    prefix.append((char) ('a' + i));
                    node = node.children[i];
                    break;
                }
            }
        }
        return prefix.toString();
    }
    
    private int countChildren(TrieNode node) {
        int count = 0;
        for (TrieNode child : node.children) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }
}
