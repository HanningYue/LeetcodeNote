class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = isPalindrome(s, i, i);
            String even = isPalindrome(s, i, i + 1);
            result = result.length() > odd.length() ? result : odd;
            result = result.length() > even.length() ? result : even;
        }
        return result;
    }
    private String isPalindrome(String s, int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < s.length()
        && s.charAt(leftPointer) == s.charAt(rightPointer)) {
            leftPointer--;
            rightPointer++;
        }
        return s.substring(leftPointer + 1, rightPointer);
    }
}