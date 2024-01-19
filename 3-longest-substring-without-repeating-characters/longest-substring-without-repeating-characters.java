class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);
            while (map.get(fastChar) > 1) {
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