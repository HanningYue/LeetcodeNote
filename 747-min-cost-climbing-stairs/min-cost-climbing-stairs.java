class Solution {
    Integer[] dpTable;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dpTable = new Integer[n + 1];
        int climbOne = dp(cost, 0);
        int climbTwo = dp(cost, 1);
        return Math.min(climbOne, climbTwo);
    }
    private int dp(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int climbOne = dp(cost, index + 1);
        int climbTwo = dp(cost, index + 2);
        dpTable[index] = cost[index] + Math.min(climbOne, climbTwo);
        return dpTable[index];
    }
}