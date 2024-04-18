/*
1. We need to first build a graph with each character in the words as key
and the character that is in order after the current word as value/
(When we build the graph, we need to make sure the words are 1. in order, and we only traverse the shorter word and break out loop after the first character)
2. Second we want to make sure there is no cycle, or repeated order 
for example a -> c and then c -> a
*/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> graph = buildGraph(words);
        if (graph == null) return "";

        Set<Character> visiting = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char currentChar : graph.keySet()) {
            if (!dfs(visiting, visited, sb, graph, currentChar)) {
                return "";
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(Set<Character> visiting, Set<Character> visited, StringBuilder sb,
                        Map<Character,Set<Character>> graph, char c) 
    {
        if (visiting.contains(c)) {
            return false;
        }
        if (visited.contains(c)) {
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

    private Map<Character,Set<Character>> buildGraph(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                return null;
            }

            for (int j = 0; j < Math.min(currentWord.length(), nextWord.length()); j++) {
                char currentChar = currentWord.charAt(j);
                char nextChar = nextWord.charAt(j);
                if (currentChar != nextChar) {
                    graph.get(currentChar).add(nextChar);
                    break;  //Only want the first one.
                }
            }
        }
        return graph;
    }
}