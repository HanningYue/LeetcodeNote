class Solution {
    public int singleNumber(int[] nums) {
        int lastDigit = 0;
        for (int i = 0; i < 32; i++) {
            int lastDigitSum = 0;
            for (int num : nums) {
                lastDigitSum += (num >> i) & 1;
            }

            lastDigitSum = lastDigitSum % 3;
            lastDigit = lastDigit | (lastDigitSum << i);
        }
        return lastDigit;
    }
}