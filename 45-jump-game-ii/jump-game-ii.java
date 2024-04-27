class Solution {
    public int jump(int[] nums) {
        int maxJumpAtEachStep = 0;
        int step = 0, furthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxJumpAtEachStep = Math.max(maxJumpAtEachStep, nums[i] + i);
            if (i == furthest) {
                step++;
                furthest = maxJumpAtEachStep;
            }
        }
        return step;
    }
}