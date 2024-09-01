class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reverse = 0;
        while (original != 0) {
            int lastDigit = original % 10;
            reverse = reverse * 10 + lastDigit;
            original = original / 10;
        }
        return reverse == x;
    }
}