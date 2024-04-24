class Solution {
    Integer[] dpTable;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dpTable = new Integer[n + 1];
        return dp(cost, n);
    }
    private int dp(int[] cost, int index) {
        if (index <= 1) {
            return 0;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int climbOne = dp(cost, index - 1) + cost[index - 1];
        int climbTwo = dp(cost, index - 2) + cost[index - 2];
        dpTable[index] = Math.min(climbOne, climbTwo);
        return dpTable[index];
    }
}