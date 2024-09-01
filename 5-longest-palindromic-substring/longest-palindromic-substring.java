class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String evenString = longest(s, i, i + 1);
            String oddString = longest(s, i, i);
            result = evenString.length() > result.length() ? evenString : result;
            result = oddString.length() > result.length() ? oddString : result;
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
