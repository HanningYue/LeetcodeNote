class Solution {
    public String alienOrder(String[] words) {
        // Initialize graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build graph relationships from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                return "";  // Not a valid lexicographical order if a longer word prefixes a shorter word
            }
            for (int j = 0; j < Math.min(currentWord.length(), nextWord.length()); j++) {
                char currentChar = currentWord.charAt(j);
                char nextChar = nextWord.charAt(j);
                if (currentChar != nextChar) {
                    graph.get(currentChar).add(nextChar);
                    break;
                }
            }
        }

        // DFS to detect cycle and topological order
        Set<Character> visiting = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char currentChar : graph.keySet()) {
            if (!dfs(visiting, visited, sb, graph, currentChar)) {
                return "";  // If a cycle is detected return an empty string
            }
        }
        return sb.reverse().toString();  // Reverse because we append characters post visiting them
    }

    private boolean dfs(Set<Character> visiting, Set<Character> visited, StringBuilder sb,
                        Map<Character, Set<Character>> graph, char c) 
    {
        if (visiting.contains(c)) {
            return false;
        }
        if (visited.contains(c) || !graph.containsKey(c)) {
            return true;
        }
        visiting.add(c);
        for (char neighbor : graph.get(c)) {
            if (!dfs(visiting, visited, sb, graph, neighbor)) {
                return false;
            }
        }
        visiting.remove(c);
        visited.add(c);
        sb.append(c);
        return true;
    }
}
