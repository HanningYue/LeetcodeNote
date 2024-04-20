class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return dfs(x, N);
    }

    public double dfs(double x, long n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return dfs(1 / x, -n);
        } else {            
            double result = dfs(x * x, n / 2);
            if (n % 2 != 0) {
                result = result * x;
            }
            return result;
        }
    }
}