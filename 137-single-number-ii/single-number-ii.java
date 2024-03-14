/**
& : 1 & 1 = 1       0 & 1 = 0       0 & 0 = 0
| : 1 | 1 = 1       0 | 1 = 1       0 | 0 = 0
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                int lastDigit = (num >> i) & 1;
                sum += lastDigit;
            }
            sum = sum % 3;
            result = result | (sum << i);
        }
        return result;
    }
}