class Solution {
    public int countSubstrings(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddCase = countOfPalindrome(s, i, i);
            int evenCase = countOfPalindrome(s, i - 1, i);
            total += oddCase;
            total += evenCase;
        }
        return total;
    }
    private int countOfPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}