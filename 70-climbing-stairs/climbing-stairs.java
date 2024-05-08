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
        int climbOne = dp(n - 1);
        int climbTwo = dp(n - 2);
        dpTable[n] = climbOne + climbTwo;
        return dpTable[n];
    }
}