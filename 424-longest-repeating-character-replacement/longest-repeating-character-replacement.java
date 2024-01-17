class Solution {
    public int characterReplacement(String s, int k) {
        int slow = 0, fast = 0;
        int maxLength = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while (fast - slow + 1 - maxFreq > k) {
                c = s.charAt(slow);
                map.put(c, map.get(c) - 1);
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
            fast++;
        }
        return maxLength;
    }
}