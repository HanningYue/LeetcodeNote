class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpAtCurrent = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJumpAtCurrent = Math.max(nums[i] + i, maxJumpAtCurrent);
            if (maxJumpAtCurrent == i) {
                return false;
            }
        }
        return true;
    }
}