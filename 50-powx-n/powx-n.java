class Solution {
    public double myPow(double x, int n) {
        return recursion(x, n);
    }
    private double recursion(double x, long n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            double result = recursion(1 / x, -n);
            return result;
        } else {
            double result = recursion(x * x, n / 2);
            if (n % 2 != 0) {
                result = result * x;
            }
            return result;
        }
    }
}