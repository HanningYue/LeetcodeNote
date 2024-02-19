class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int eachWordLength = words[0].length();
        int wordCount = words.length;
        int permutationLength = eachWordLength * wordCount;

        for (int i = 0; i + permutationLength <= s.length(); i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int nextWordStart = i + j * eachWordLength;
                String nextWord = s.substring(nextWordStart, nextWordStart + eachWordLength);
                if (!map.containsKey(nextWord)) {
                    break;
                }
                localMap.put(nextWord, localMap.getOrDefault(nextWord, 0) + 1);
                if (localMap.get(nextWord) > map.get(nextWord)) {
                    break;
                }
                if (j + 1 == wordCount) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}