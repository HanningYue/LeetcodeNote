class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if (maxJump == i) {
                return false;
            }
        }
        return maxJump >= nums.length - 1;
    }
}