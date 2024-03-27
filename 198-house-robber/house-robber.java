class Solution {
    Integer[] dpTable;
    public int rob(int[] nums) {
        dpTable = new Integer[nums.length];
        return dp(nums, 0);
    }
    private int dp(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }

        dpTable[index] = Math.max(dp(nums, index + 1), dp(nums, index + 2) + nums[index]);
        return dpTable[index];
    }
}