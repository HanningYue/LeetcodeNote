class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        int maxLength = 0;
        while (fast < s.length()) {
            while (!set.add(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
            set.add(s.charAt(fast));
            fast++;
        }
        return maxLength;
    }
}