class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String even = substring(s, i - 1, i);
            String odd = substring(s, i, i);
            result = result.length() > even.length() ? result : even;
            result = result.length() > odd.length() ? result : odd;
        }
        return result;
    }
    private String substring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}