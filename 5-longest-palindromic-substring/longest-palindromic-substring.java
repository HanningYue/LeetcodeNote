class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String evenCase = recursion(s, i - 1, i);
            String oddCase = recursion(s, i, i);
            result = evenCase.length() > result.length() ? evenCase : result;
            result = oddCase.length() > result.length() ? oddCase : result;
        }
        return result;
    }
    private String recursion(String s, int leftP, int rightP) {
        while (leftP >= 0 && rightP < s.length() && s.charAt(leftP) == s.charAt(rightP)) {
            leftP--;
            rightP++;
        }
        return s.substring(leftP + 1, rightP);
    }
}