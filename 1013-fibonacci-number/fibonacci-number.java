/**
top-bottom recursion
f(20) -> f(19) -> ... -> f(1)
bottom-top dp
    Create a dp table to save from dp[0] -> dp[1] -> dp[i] = dp[i - 2] + dp[i - 1]
    When creating, always int[n + 1] because dp[0] = 0
*/
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int dpi1 = 0, dpi2 = 1;
        for (int i = 2; i <= n; i++) {
            int dpi3 = dpi1 + dpi2;
            //Update DP table
            dpi1 = dpi2;
            dpi2 = dpi3;
        }
        return dpi2;
    }
}