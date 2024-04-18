class Solution {
    Boolean[] dpTable;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dpTable = new Boolean[n];
        return dp(nums, 0);
    }
    private boolean dp(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int maxJump = Math.min(nums[index] + index, nums.length - 1);
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            if (dp(nums, nextIndex)) {
                dpTable[index] = true;
                return true;
            }
        }
        dpTable[index] = false;
        return false;
    }
}