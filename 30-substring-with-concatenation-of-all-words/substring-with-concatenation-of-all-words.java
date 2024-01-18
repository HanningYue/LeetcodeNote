class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!map.containsKey(word))
                    break;
                localMap.put(word, localMap.getOrDefault(word, 0) + 1);
                if (localMap.get(word) > map.getOrDefault(word, 0))
                    break;
                if (j + 1 == wordsCount)
                    resultIndices.add(i);
            }
        }
        return resultIndices;
    }
}