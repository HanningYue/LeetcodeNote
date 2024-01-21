class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int num : nums) {
            runningSum += num;
            result = Math.max(result, runningSum);
            if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return result;
    }
}