class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0, fast = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
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