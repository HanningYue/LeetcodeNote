class Solution {
    Integer[] dpTable;
    public int climbStairs(int n) {
        dpTable = new Integer[n + 1];
        return dp(n);
    }
    private int dp(int n) {
        if (n <= 2) {
            return n;
        }
        if (dpTable[n] != null) {
            return dpTable[n];
        }
        dpTable[n] = dp(n - 1) + dp(n - 2);
        return dpTable[n];
    }
}