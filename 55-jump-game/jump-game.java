class Solution {
    public boolean canJump(int[] nums) {
        int furthestJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthestJump = Math.max(furthestJump, nums[i] + i);
            if (furthestJump == i) {
                return false;
            }
        }
        return furthestJump >= nums.length - 1;
    }
}