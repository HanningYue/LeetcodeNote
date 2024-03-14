public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            
            int lastDigit = n & 1;
            if (lastDigit != 0) {
                result = result + 1;
            }

            n = n >> 1;
        }
        return result;
    }
}