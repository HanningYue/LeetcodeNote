class Solution {
    int[] dpTable;
    public int climbStairs(int n) {
        dpTable = new int[n + 1];
        return dp(n);
    }
    private int dp(int n) {
        if (n <= 2) {
            return n;
        }
        if (dpTable[n] != 0) {
            return dpTable[n];
        }
        dpTable[n] = dp(n - 1) + dp(n - 2);
        return dpTable[n];
    }
}