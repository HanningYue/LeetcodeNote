/*
Non-fixed size sliding window, need to check duplicate, use a Set<>
If the character at FAST index is already contained in Set, remove the character at SLOW index
    Because we want the longest substring without duplicate character, we keep removing 
    slow index character until remove the one that is currently at FAST index
Update max length at each iteration of fast, compare Math.max(fast - slow + 1, maxLength)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int maxLength = 0;
        
        for (int fast = 0; fast < s.length(); fast++) {
            while (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            }
            set.add(s.charAt(fast));
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}