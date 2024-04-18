class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                slow = Math.max(slow, map.get(fastChar));
            }
            map.put(fastChar, fast + 1);
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}