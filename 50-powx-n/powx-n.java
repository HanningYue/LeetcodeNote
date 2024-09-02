class Solution {
    public double myPow(double x, int n) {
        return recursion(x, n);
    }
    private double recursion(double x, int n) {
        double result = 1.0;
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}