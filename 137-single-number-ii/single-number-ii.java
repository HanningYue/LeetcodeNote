class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lastDigitSum = 0;
            for (int num : nums) {
                lastDigitSum += (num >> i) & 1;
            }
            lastDigitSum %= 3;
            result = result | (lastDigitSum << i);
        }
        return result;
    }
}