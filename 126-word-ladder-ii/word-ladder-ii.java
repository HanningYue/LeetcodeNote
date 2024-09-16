class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //Build Map
        Map<String, Set<String>> map = process(beginWord, endWord, wordList); //{word in wordList : word that is one char different}
        if (!map.containsKey(endWord)) return new ArrayList<>(); //Edge case, endWord is not in wordList

        //BFS
        Queue<String> queue = new ArrayDeque<>();
        Map<String, List<String>> parents = new HashMap<>(); //{currentword : previous word that changed one char to current word}
        queue.offer(beginWord);
        parents.put(beginWord, null); 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<String, List<String>> tempMap = new HashMap<>(); //Because parents map will change, create a copy called tempMap
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : map.get(current)) {
                    if (!parents.containsKey(next)) {
                        if (!tempMap.containsKey(next)) {
                            queue.offer(next);
                        }
                        tempMap.putIfAbsent(next, new ArrayList<>());
                        tempMap.get(next).add(current); //Bidirectional BFS
                    }
                }
            }

            parents.putAll(tempMap);
            if (parents.containsKey(endWord)) { //If endWord is found, add to the result
                List<List<String>> result = new ArrayList<>();
                List<String> path = new ArrayList<>();
                path.add(endWord); //Go reverse to find the path
                dfs(result, path, parents, beginWord, endWord);
                return result;
            }
        }
        return new ArrayList<>();
    }

    private void dfs(List<List<String>> result, List<String> path, Map<String, List<String>> parents, String beginWord, String endWord) {
        if (endWord.equals(beginWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (String previousWord : parents.get(endWord)) {
            path.add(0, previousWord);
            dfs(result, path, parents, beginWord, previousWord);
            path.remove(0);
        }
    }

    private Map<String, Set<String>> process(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word1 : wordList) {
            if (oneDiff(beginWord, word1)) {    //put beginWord first, because it is not in the wordList
                map.putIfAbsent(beginWord, new HashSet<>());
                map.get(beginWord).add(word1);
            }

            for (String word2 : wordList) {
                if (oneDiff(word1, word2)) {
                    map.putIfAbsent(word1, new HashSet<>());
                    map.get(word1).add(word2);
                }
            }
        }
        return map;
    }

    private boolean oneDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {  //word1.length() == word2.length() given in the question
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}