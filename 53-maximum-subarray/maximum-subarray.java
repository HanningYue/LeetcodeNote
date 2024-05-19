class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int result = nums[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}