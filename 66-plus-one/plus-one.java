class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int currentDigit = digits[i];
            if (currentDigit < 9) {
                digits[i]++;
                return digits;
            } else if (currentDigit == 9) {
                digits[i] = 0;
            }
        }

        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}