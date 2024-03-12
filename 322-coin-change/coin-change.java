class Solution {
    int[] dpTable;
    public int coinChange(int[] coins, int amount) {
        dpTable = new int[amount + 1];
        Arrays.fill(dpTable, -100);
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dpTable[amount] != -100) {
            return dpTable[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            result = Math.min(result, sub + 1);
        }
        dpTable[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return dpTable[amount];
    }
}