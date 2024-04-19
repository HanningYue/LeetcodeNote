class Solution {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (reverse > 0) {
                if (reverse > Integer.MAX_VALUE / 10 
                || reverse == Integer.MAX_VALUE / 10 && lastDigit > Integer.MAX_VALUE % 10) {
                    return 0;
                }
            } else if (reverse < 0) {
                if (reverse < Integer.MIN_VALUE / 10
                || reverse == Integer.MIN_VALUE / 10 && lastDigit < Integer.MIN_VALUE % 10) {
                    return 0;
                }
            }
            x = x / 10;
            reverse = reverse * 10 + lastDigit;
        }
        return reverse;
    }
}