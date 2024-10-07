class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);        
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                char upperLeft = Character.toUpperCase(leftChar);
                char upperRight = Character.toUpperCase(rightChar);
                if (upperLeft != upperRight) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}