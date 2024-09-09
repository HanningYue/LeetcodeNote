class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
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
        for (char c : graph.keySet()) {
            if (!dfs(c, visiting, visited, graph, sb)) {
                return "";
            }
        }
        return sb.toString();
    }
    private boolean dfs(char c, Set<Character> visiting, Set<Character> visited, 
    Map<Character, Set<Character>> graph, StringBuilder sb) {
        if (visiting.contains(c)) {
            return false;
        }   
        if (visited.contains(c)) {
            return true;
        }   
        visiting.add(c);
        for (char neighbor : graph.get(c)) {
            if (!dfs(neighbor, visiting, visited, graph, sb)) {
                return false;
            }
        } 
        visited.add(c);
        visiting.remove(c);
        sb.append(c);
        return true;
    }  
}