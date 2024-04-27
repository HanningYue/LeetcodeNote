class Solution {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        // Initialize memoization table with nulls
        memo = new Integer[amount + 1];
        int result = dp(coins, amount);
        // If the result is still Integer.MAX_VALUE after computation, it means it's not possible to form the amount
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dp(int[] coins, int amount) {
        // Base case: when amount is 0, no coins are needed
        if (amount == 0) return 0;
        // If amount is less than 0, there's no valid solution
        if (amount < 0) return Integer.MAX_VALUE;
        // If we've already computed the minimum for this amount, return it
        if (memo[amount] != null) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        // Try every coin in the array
        for (int coin : coins) {
            int res = dp(coins, amount - coin);
            // If res is not Integer.MAX_VALUE, it means it's possible to form the amount (amount - coin)
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1); // Update minCoins by adding 1 to the result from the subproblem
            }
        }

        // Memoize and return the computed minimum number of coins for this amount
        memo[amount] = minCoins;
        return minCoins;
    }
}
