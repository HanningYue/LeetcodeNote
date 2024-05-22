class Solution {
    public double myPow(double x, int n) {
        return iterative(x, n);
    }

    private double iterative(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        } else if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }
        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}