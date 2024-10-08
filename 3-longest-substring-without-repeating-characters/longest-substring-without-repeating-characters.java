class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        int maxLength = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            while (!set.add(fastChar)) {
                char slowChar = s.charAt(slow);
                set.remove(slowChar);
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
            fast++;
        }
        return maxLength;
    }
}