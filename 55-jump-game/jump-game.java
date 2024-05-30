class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpAtEachStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJumpAtEachStep = Math.max(maxJumpAtEachStep, i + nums[i]);
            if (maxJumpAtEachStep == i) {
                return false;
            }
        }
        return maxJumpAtEachStep >= nums.length - 1;
    }
}