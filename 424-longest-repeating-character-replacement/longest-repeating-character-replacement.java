class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, maxFreq = 0;
    
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(fastChar));

            while (fast - slow + 1 - maxFreq > k) {
                char slowChar = s.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);
                slow++;
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        
        return result;
    }
}