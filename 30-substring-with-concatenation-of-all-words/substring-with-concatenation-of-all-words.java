class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int eachWordLength = words[0].length();
        int totalLength = words.length * eachWordLength;

        for (int i = 0; i + totalLength <= s.length(); i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int nextWordStart = i + j * eachWordLength;
                String nextWord = s.substring(nextWordStart, nextWordStart + eachWordLength);
                if (!map.containsKey(nextWord)){
                    break;
                }
                localMap.put(nextWord, localMap.getOrDefault(nextWord, 0) + 1);
                if (map.get(nextWord) < localMap.get(nextWord)) {
                    break;
                }
                if (j + 1 == words.length) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}