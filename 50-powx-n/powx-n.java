class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return recursion(x, N);
    }
    public double recursion(double x, long n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            x = 1 / x;
            n = -n;
            return recursion(x, n);
        } else {
            double result = recursion(x * x, n / 2);
            if (n % 2 == 1) {
                result = result * x;
            }
            return result;
        }
    }
}
