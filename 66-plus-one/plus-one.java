class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int currentDigit = digits[i];

            if (currentDigit == 9) {
                digits[i] = 0;
            } else if (currentDigit < 9) {
                digits[i]++;
                return digits;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = digits[i];
        }
        return result;
    }
}