class Solution {
    int[] dpTable;
    public int rob(int[] nums) {
        dpTable = new int[nums.length];
        Arrays.fill(dpTable, -1);
        return dp(nums, 0);
    }
    private int dp(int[] nums, int startIdx) {
        if (startIdx >= nums.length) {
            return 0;
        }
        if (dpTable[startIdx] != -1) {
            return dpTable[startIdx];
        }

        int result = Math.max(dp(nums, startIdx + 1), nums[startIdx] + dp(nums, startIdx + 2));
        dpTable[startIdx] = result;
        return result;
    }
}