class Solution {
    Integer[] dpTable;
    public int rob(int[] nums) {
        int m = nums.length;
        dpTable = new Integer[m];
        return dp(nums, 0);
    }
    private int dp(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int robCurrent = dp(nums, index + 2) + nums[index];
        int notRobCurrent = dp(nums, index + 1);
        dpTable[index] = Math.max(robCurrent, notRobCurrent);
        return dpTable[index];
    }
}