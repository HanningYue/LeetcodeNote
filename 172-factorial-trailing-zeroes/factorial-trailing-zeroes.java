//两个数相乘结果末尾有 0，一定是因为两个数中有因子 2 和 5，因为 10 = 2 x 5
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