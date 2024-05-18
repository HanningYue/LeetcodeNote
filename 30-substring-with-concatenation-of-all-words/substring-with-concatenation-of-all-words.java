class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordCount = words.length;
        int eachWordLength = words[0].length(), totalLength = wordCount * eachWordLength;
        for (int i = 0; i + totalLength <= s.length(); i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int startOfNextWord = i + j * eachWordLength;
                String nextWord = s.substring(startOfNextWord, startOfNextWord + eachWordLength);
                if (!map.containsKey(nextWord)) {
                    break;
                }

                localMap.put(nextWord, localMap.getOrDefault(nextWord, 0) + 1);
                if (localMap.get(nextWord) > map.get(nextWord)) {
                    break;
                }

                if (j == wordCount - 1) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}