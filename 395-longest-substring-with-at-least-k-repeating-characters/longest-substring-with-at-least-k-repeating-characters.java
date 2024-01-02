class Solution {
    public int longestSubstring(String s, int k) {
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            result = Math.max(result, helper(s, k, i));
        }
        return result;
    }
    private int helper(String s, int k, int count) {
        int validChar = 0, uniqueChar = 0;
        int slow = 0, fast = 0, length = 0;
        int[] freq = new int[26];

        while (fast < s.length()) {
            char current = s.charAt(fast);
            if (freq[current - 'a'] == 0) {
                uniqueChar++;
            }
            freq[current - 'a']++;
            if (freq[current - 'a'] == k) {
                validChar++;
            }

            while (uniqueChar > count) {
                char delete = s.charAt(slow);
                if (freq[delete - 'a'] == k) {
                    validChar--;
                }
                freq[delete - 'a']--;
                if (freq[delete - 'a'] == 0) {
                    uniqueChar--;
                }
                slow++;
            }
            
            if (validChar == count) {
                length = Math.max(length, fast - slow + 1);
            }
            fast++;
        }
        return length;
    }
}