class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            while (!set.add(fastChar)) {
                char slowChar = s.charAt(slow);
                set.remove(slowChar);
                slow++;
            }
            length = Math.max(length, fast - slow + 1);
            fast++;
        }
        return length;
    }
}