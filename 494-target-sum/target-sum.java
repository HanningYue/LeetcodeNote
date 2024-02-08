class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }        
        backTrack(nums, 0, target);
        return result;
    }
    private int result = 0;
    private void backTrack(int[] nums, int index, int remain) {
        if (index == nums.length) {
            if (remain == 0) {
                result++;
            }
            return;
        }
        remain += nums[index];
        backTrack(nums, index + 1, remain);
        remain -= nums[index];

        remain -= nums[index];
        backTrack(nums, index + 1, remain);
        remain += nums[index];
    }
}