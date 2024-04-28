class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int even = isPalindrome(s, i, i + 1);
            int odd = isPalindrome(s, i, i);
            count += even;
            count += odd;
        }
        return count;
    }
    private int isPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}