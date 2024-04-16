class Solution {
    Integer[] dpTable;
    public int minCostClimbingStairs(int[] cost) {
        dpTable = new Integer[cost.length];
        int startFromLast = dp(cost, cost.length - 1);
        int startFromSecondLast = dp(cost, cost.length - 2);
        return Math.min(startFromLast, startFromSecondLast);
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

        int climbOneCost = dp(cost, index - 1);
        int climbTwoCost = dp(cost, index - 2);
        dpTable[index] = Math.min(climbOneCost, climbTwoCost) + cost[index];
        return dpTable[index];
    }
}