/**
Greedy
Add current num to runningSum each iteration
Update each max during each iteration, before reset runningSum to 0, when less than 0.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0, maxSum = Integer.MIN_VALUE;
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