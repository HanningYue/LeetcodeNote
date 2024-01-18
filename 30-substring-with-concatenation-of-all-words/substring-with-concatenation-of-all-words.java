class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        int wordCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - wordCount * wordLength; i++) {
            Map<String, Integer> localMap = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int nextStartIdx = i + j * wordLength;
                String nextWord = s.substring(nextStartIdx, nextStartIdx + wordLength);
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