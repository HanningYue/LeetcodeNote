class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                return "";
            }

            for (int j = 0; j < Math.min(currentWord.length(), nextWord.length()); j++) {
                char currentChar = currentWord.charAt(j);
                char nextChar = nextWord.charAt(j);

                if (currentChar != nextChar) {
                    graph.get(nextChar).add(currentChar);
                    break;
                }
            }
        }

        Set<Character> visiting = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char currentChar : graph.keySet()) {
            if (!dfs(visiting, visited, sb, graph, currentChar)) {
                return "";
            }
        }
        return sb.toString();
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
