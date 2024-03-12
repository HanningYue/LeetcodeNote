class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int result = 0, currentMax = 0, currentMin = 0;
        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            result += num;
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, result - minSum);
    }
}