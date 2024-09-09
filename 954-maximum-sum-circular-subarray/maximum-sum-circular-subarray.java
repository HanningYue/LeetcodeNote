class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int totalSum = 0;
        int runningMax = 0, runningMin = 0;

        for (int i = 0; i < nums.length; i++) {
            runningMax = Math.max(runningMax + nums[i], nums[i]);
            maximum = Math.max(maximum, runningMax);

            runningMin = Math.min(runningMin + nums[i], nums[i]);
            minimum = Math.min(minimum, runningMin);

            totalSum += nums[i];
        }
        if (maximum < 0) {
            return maximum;
        }
        int result = Math.max(maximum, totalSum - minimum);
        return result;
    }
}