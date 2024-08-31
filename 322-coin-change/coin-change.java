class Solution {
    Integer[] dpTable;
    public int coinChange(int[] coins, int amount) {
        dpTable = new Integer[amount + 1];
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (dpTable[amount] != null) {
            return dpTable[amount];
        }
        
        int minimal = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem != -1) {
                minimal = Math.min(minimal, subProblem + 1);
            }
        } 
        dpTable[amount] = minimal == Integer.MAX_VALUE ? -1 : minimal;
        return dpTable[amount];
    }
}