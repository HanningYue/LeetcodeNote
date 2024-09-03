class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        long divisor = 5;

        while (divisor <= n) {
            long numberOfDivisor = n / divisor;
            result += numberOfDivisor;
            divisor = divisor * 5;
        }
        return result;        
    }
}