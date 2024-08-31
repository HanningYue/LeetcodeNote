class Solution {
    Integer[] dpTable;
    public int climbStairs(int n) {
        dpTable = new Integer[n + 1];
        return dp(n);
    }
    private int dp(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dpTable[n] != null) {
            return dpTable[n];
        }
        int oneStep = dp(n - 1);
        int twoStep = dp(n - 2);
        dpTable[n] = oneStep + twoStep;
        return dpTable[n];
    }
}