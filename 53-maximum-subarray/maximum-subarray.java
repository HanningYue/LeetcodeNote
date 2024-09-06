class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maxSum = Integer.MIN_VALUE;
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