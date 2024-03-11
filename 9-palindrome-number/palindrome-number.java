class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int current = x;
        int reverse = 0;
        while (current > 0) {
            int lastDigit = current % 10;
            current = current / 10;
            reverse = reverse * 10 + lastDigit;
        }
        return reverse == x;
    }
}