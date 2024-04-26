class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Math.min(nums[0], 0);
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];

            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}