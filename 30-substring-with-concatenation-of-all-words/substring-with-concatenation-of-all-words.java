class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        for (int i = 0; i <= s.length() - wordLength * wordCount; i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                Integer nextWordStart = i + j * wordLength;
                String nextWord = s.substring(nextWordStart, nextWordStart + wordLength);
                if (!map.containsKey(nextWord))
                    break;
                localMap.put(nextWord, localMap.getOrDefault(nextWord, 0) + 1);
                if (localMap.get(nextWord) > map.get(nextWord))
                    break;
                if (j + 1 == wordCount)
                    result.add(i);
            }
        }
        return result;
    }
}