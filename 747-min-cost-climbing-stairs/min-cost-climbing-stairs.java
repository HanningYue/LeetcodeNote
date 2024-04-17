class Solution {
    Integer[] dpTable;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dpTable = new Integer[n];
        int startFromLast = dp(cost, n - 1);
        int startFromSecondLast = dp(cost, n - 2);
        return Math.min(startFromLast, startFromSecondLast);
    }
    private int dp(int[] cost, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 1 || index == 0) {
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