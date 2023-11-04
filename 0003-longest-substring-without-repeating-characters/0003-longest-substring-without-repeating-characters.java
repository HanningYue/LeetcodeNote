/**
1. want to find the longest substring without repeating characters
2. need to apply sliding window technique, non-fixed size, using a hashset to handle duplicates
3. the removing condition is when we cannot add fast char into set
4. ATTENTION, increase slow aftert removing the slow char, to the next non-fast-duplicate char
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0, length = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            if (!set.add(s.charAt(fast))) {
                while (s.charAt(slow) != s.charAt(fast)) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            length = Math.max(length, fast - slow + 1);
        }
        return length;
    }
}