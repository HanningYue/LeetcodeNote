/**
Map, character and frequency
Fast and slow pointer,
While the char frequency is less than k,  */
class Solution {
    public int longestSubstring(String s, int k) {
        int len = 0;
        for (int i = 1; i <= 26; i++) {
            len = Math.max(len, helper(s, k, i));
        }
        return len;
    }
    private int helper(String s, int k, int count) {
        int result = 0, slow = 0, fast = 0;
        int[] windowSize = new int[26];
        int uniqueCount = 0, validCount = 0;

        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (windowSize[c - 'a'] == 0) {
                uniqueCount++;
            }
            windowSize[c - 'a']++;
            if (windowSize[c - 'a'] == k) {
                validCount++;
            }
            fast++;

            while (uniqueCount > count) {
                char delete = s.charAt(slow);
                if (windowSize[delete - 'a'] == k) {
                    validCount--;
                }
                windowSize[delete - 'a']--;
                if (windowSize[delete - 'a'] == 0) {
                    uniqueCount--;
                }
                slow++;
            }

            if (validCount == count) {
                result = Math.max(result, fast - slow);
            }
        }
        return result;
    }
}