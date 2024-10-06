class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar) && map.get(fastChar) >= slow) {
                slow = map.get(fastChar) + 1;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
            map.put(fastChar, fast);
            fast++;
        }
        return maxLength;
    }
}
