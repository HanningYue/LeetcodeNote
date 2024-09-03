public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = reversed << 1;
            int lastDigit = n & 1;
            if (lastDigit != 0) {
                reversed++;
            }
            n = n >> 1;
        }
        return reversed;
    }
}