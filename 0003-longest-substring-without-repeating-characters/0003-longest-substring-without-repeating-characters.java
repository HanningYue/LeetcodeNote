class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int slow = 0;
        int length = Integer.MIN_VALUE;
        
        for (int fast = 0; fast < s.length(); fast++) {
            while (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            }
            set.add(s.charAt(fast));
            length = Math.max(length, fast - slow + 1);
        }
        return length == Integer.MIN_VALUE ? 0 : length;
    }
}