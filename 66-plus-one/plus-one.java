class Solution {
    public int[] plusOne(int[] digits) {
        int lastIdx = digits.length - 1;
        while (lastIdx >= 0) {
            if (digits[lastIdx] < 9) {
                digits[lastIdx]++;
                return digits;
            } else if (digits[lastIdx] == 9) {
                digits[lastIdx] = 0;                
                lastIdx--;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}