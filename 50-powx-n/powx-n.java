class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }
    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return helper(1 / x, -n);
        }

        double result = helper(x * x, n / 2);
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }
}