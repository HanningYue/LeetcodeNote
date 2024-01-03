public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toUpperCase();
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (!Character.isLetterOrDigit(leftC)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightC)) {
                right--;
            } else {
                if (leftC != rightC) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}