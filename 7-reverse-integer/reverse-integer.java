class Solution {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            int tempResult = reverse * 10 + lastDigit;
            if (tempResult / 10 != reverse) {
                return 0;
            }
            reverse = reverse * 10 + lastDigit;
            x = x / 10;
        }
        return reverse;
    }
}