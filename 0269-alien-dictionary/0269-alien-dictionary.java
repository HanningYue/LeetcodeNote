/* 关键点在于构建map, the final map should be {single character -> Set<Character> set}
1. Map<Character, Set<Character>, In this process : Check currentWord length with nextWord length, and if currentWord startsWith(nextWord). If equal and startswith nextword, clear map and return empty map
2. After, in the boundary of min(currentword and nextword), iterate character and check equivalence. Only want first one letter corresponding to the next one. (比如acb，aed) c一定在e之前,但b不一定在d之前 so break after one iteration of comparsion in while loop

Step one: build map
Step two: DFSII, check cycle, use a stringbuilder to record order
Step three: Return the .reverse of stringbuilder because nature of DFS
*/
class Solution {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        Set<Character> visiting = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        Map<Character, Set<Character>> map = buildMap(words);
        for (Character c : map.keySet()) {
            if (!dfs(map, visiting, visited, c, sb)) {
                return "";
            }    
        }
        return sb.reverse().toString();
    }
    
    private Map<Character, Set<Character>> buildMap (String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                map.clear();
                return map;
            }
            for (int j = 0; j < Math.min(currentWord.length(), nextWord.length()); j++) {
                char currentC = currentWord.charAt(j);
                char nextC = nextWord.charAt(j);
                if (currentC != nextC) {
                    map.get(currentC).add(nextC);
                    break;
                }
            }
        }
        return map;
    }
    
    private boolean dfs (Map<Character, Set<Character>> map, Set<Character> visiting, 
                         Set<Character> visited, char c, StringBuilder sb)
    {
        if (visiting.contains(c)) return false;
        if (visited.contains(c)) return true;
        
        visiting.add(c);
        for (char neighbor : map.get(c)) {
            if (!dfs(map, visiting, visited, neighbor, sb)){
                return false;   
            }
        }
        visiting.remove(c);
        visited.add(c);
        sb.append(c);
        return true;
    }
}