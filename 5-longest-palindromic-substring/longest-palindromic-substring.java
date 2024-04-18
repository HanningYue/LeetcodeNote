class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String even = palindrome(s, i, i + 1);
            String odd = palindrome(s, i, i);
            result = even.length() > result.length() ? even : result;
            result = odd.length() > result.length() ? odd : result;
        }
        return result;
    }
    private String palindrome(String s, int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
            leftPointer--;
            rightPointer++;
        }
        return s.substring(leftPointer + 1, rightPointer);
    }
}