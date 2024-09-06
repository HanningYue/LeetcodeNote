class Solution {
    Integer[] dp;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        dp = new Integer[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}