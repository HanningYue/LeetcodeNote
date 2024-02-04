class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    public TrieNode() {
        
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            result.add(trie.search(prefix.toString()));
        }
        return result;
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
    public List<String> search(String prefix) {
        TrieNode node = root;
        List<String> list = new ArrayList<>();

        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return list;
            }
            node = node.children[c - 'a'];
        }

        StringBuilder sb = new StringBuilder(prefix);
        dfs(node, list, sb);
        return list;
    }
    public void dfs(TrieNode node, List<String> list, StringBuilder sb) {
        if (list.size() == 3) {
            return;
        }
        if (node.isEnd) {
            list.add(sb.toString());
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                sb.append(c);
                dfs(node.children[c - 'a'], list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}