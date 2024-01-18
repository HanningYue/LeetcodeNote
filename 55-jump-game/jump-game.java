class Solution {
    public boolean canJump(int[] nums) {
        int furthest = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= furthest)
                furthest = i;
        }
        return furthest == 0;
    }
}