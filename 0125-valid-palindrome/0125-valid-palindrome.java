/*
Want to return a boolean value, check whether String s is a palindrome
Use two pointer technique, leftPointer to right and rightPointer to left
    In while loop, if leftChar == rightChar, we keep going, if not return false
        ATTENTION, when encounter 'space' or 'punctuation', continue and keep moving pointer
If all case passes, return true, if another character is not the same, return false
*/
class Solution {
    public boolean isPalindrome(String s) {
        int leftP = 0, rightP = s.length() - 1;
        
        while (leftP < rightP) {
            char leftC = s.charAt(leftP);
            char rightC = s.charAt(rightP);
            
            if (!Character.isLetterOrDigit(leftC)) {
                leftP++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightC)) {
                rightP--;
                continue;
            }
            if (Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {
                return false;
            }
            leftP++;
            rightP--;
        }
        return true;
    }
}