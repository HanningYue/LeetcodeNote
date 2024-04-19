class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int step = 0, currentMaxJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if (currentMaxJump == i) {
                step++;
                currentMaxJump = maxJump;
            }
        }
        return step;
    }
}