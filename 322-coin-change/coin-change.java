class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -100);
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -100) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            result = Math.min(result, sub + 1);
        }
        memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return memo[amount];
    }
}