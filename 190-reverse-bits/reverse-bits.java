public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            int lastDigit = n & 1;
            if (lastDigit != 0) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}