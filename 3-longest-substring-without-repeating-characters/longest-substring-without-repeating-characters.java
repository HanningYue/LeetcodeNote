class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0, maxLength = 0;
        while (fast < s.length()) {
            if (set.add(s.charAt(fast))) {
                maxLength = Math.max(maxLength, fast - slow + 1);
                fast++;
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return maxLength;
    }
}