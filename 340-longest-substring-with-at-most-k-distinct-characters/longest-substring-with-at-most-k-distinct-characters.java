class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int slow = 0, fast = 0;
        int maxLength = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);

            while (map.size() > k) {
                char slowChar = s.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);
                if (map.get(slowChar) == 0) {
                    map.remove(slowChar);
                }

                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
            fast++;
        }
        return maxLength;
    }
}