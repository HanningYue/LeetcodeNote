class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = longest(s, i - 1, i);
            String even = longest(s, i, i);
            result = odd.length() > result.length() ? odd : result;
            result = even.length() > result.length() ? even : result;
        }
        return result;
    }
    private String longest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}