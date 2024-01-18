class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        List<Integer> result = new ArrayList<Integer>();
        int wordsCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordStart = i + j * wordLength;
                String word = s.substring(nextWordStart, nextWordStart + wordLength);
                if (!map.containsKey(word))
                    break;
                localMap.put(word, localMap.getOrDefault(word, 0) + 1);
                if (localMap.get(word) > map.get(word))
                    break;
                if (j + 1 == wordsCount)
                    result.add(i);
            }
        }
        return result;
    }
}