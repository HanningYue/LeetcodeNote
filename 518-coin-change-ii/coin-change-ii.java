class Solution {
    private Integer[][] memo;

    public int change(int amount, int[] coins) {
        // Initialize the memoization table with null
        // Using a 2D array because the state of our DP depends on both the amount and the current index of coins being processed
        memo = new Integer[coins.length][amount + 1];
        return dp(coins, 0, amount);
    }

    private int dp(int[] coins, int index, int amount) {
        // Base case: if amount is 0, we found a valid combination
        if (amount == 0) {
            return 1;
        }
        // If we've considered all coins or amount has gone negative, no valid combination
        if (index == coins.length || amount < 0) {
            return 0;
        }
        // If this subproblem has already been solved, return the stored result
        if (memo[index][amount] != null) {
            return memo[index][amount];
        }

        // Calculate number of combinations by:
        // 1. Including the current coin and seeing how many ways we can form the remaining amount
        // 2. Not including the current coin and moving to the next coin
        int includeCurrentCoin = dp(coins, index, amount - coins[index]);  // Use the current coin
        int excludeCurrentCoin = dp(coins, index + 1, amount);             // Do not use the current coin

        // Memoize and return the result
        memo[index][amount] = includeCurrentCoin + excludeCurrentCoin;
        return memo[index][amount];
    }
}
