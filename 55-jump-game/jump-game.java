class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpAtEachStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJumpAtEachStep = Math.max(maxJumpAtEachStep, nums[i] + i);
            if (i == maxJumpAtEachStep) {
                return false;
            }
        }
        return maxJumpAtEachStep >= nums.length - 1;
    }
}