class Solution {
    Integer[] dpTable;
    public int minCostClimbingStairs(int[] cost) {
        dpTable = new Integer[cost.length];
        return Math.min(dp(cost, cost.length - 1), dp(cost, cost.length - 2));
    }
    private int dp(int[] cost, int index) {
        if (index < 0) {
            return 0;
        }
        if (index < 2) {
            return cost[index];
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int climbOne = dp(cost, index - 1);
        int climbTwo = dp(cost, index - 2);
        dpTable[index] = Math.min(climbOne, climbTwo) + cost[index];
        return dpTable[index];
    }
}