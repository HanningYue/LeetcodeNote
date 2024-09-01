class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int maxK = k; maxK >= 1; maxK--) {
                if (i - 1 == -1) {
                    dp[i][maxK][0] = 0;
                    dp[i][maxK][1] = 0 - prices[i];
                    continue;
                }

                dp[i][maxK][0] = Math.max(dp[i - 1][maxK][0], dp[i - 1][maxK][1] + prices[i]);
                dp[i][maxK][1] = Math.max(dp[i - 1][maxK][1], dp[i - 1][maxK - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}