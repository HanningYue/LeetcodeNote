class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String evenCase = palindrome(s, i, i + 1);
            String oddCase = palindrome(s, i, i);
            result = evenCase.length() > result.length() ? evenCase : result;
            result = oddCase.length() > result.length() ? oddCase : result;
        }
        return result;
    }
    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}