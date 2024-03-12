//A subarray may only include each element of the fixed buffer nums at most once.
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int currentMax = 0, currentMin = 0;
        int totalSum = 0;
        for (int num : nums) {
            currentMax = Math.max(num, num + currentMax);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, num + currentMin);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(totalSum - minSum, maxSum);
    }
}