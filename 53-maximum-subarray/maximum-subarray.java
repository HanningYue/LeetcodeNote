class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0], min = Math.min(0, nums[0]);

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}