class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int num : nums) {
            runningSum += num;
            maxSum = Math.max(maxSum, runningSum);
            if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return maxSum;
    }
}