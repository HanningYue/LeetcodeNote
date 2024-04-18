class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (runningSum < 0) {
                runningSum = 0;
            }
            runningSum += num;
            result = Math.max(result, runningSum);
        }
        return result;
    }
}