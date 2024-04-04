class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == furthest) {
                return false;
            }
        }

        return furthest >= nums.length - 1;
    }
}