class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0;
        int length = 0;

        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                if (map.get(fastChar) >= slow) {
                    slow = map.get(fastChar) + 1;
                }
            }
            length = Math.max(length, fast - slow + 1);
            map.put(fastChar, fast);
            fast++;
        }
        return length;
    }
}