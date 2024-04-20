class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return helper(x, N);
    }
    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x;
                n--;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}