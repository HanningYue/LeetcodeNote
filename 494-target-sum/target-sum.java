class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }        
        backTrack(nums, 0, target, 0);
        return result;
    }
    private int result = 0;
    private void backTrack(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                result++;
            }
            return;
        }
        sum += nums[index];
        backTrack(nums, index + 1, target, sum);
        sum -= nums[index];

        sum -= nums[index];
        backTrack(nums, index + 1, target, sum);
        sum += nums[index];
    }
}