class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int runningMin = 0, runningMax = 0;
        int globalMin = Integer.MAX_VALUE, globalMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            runningMax = Math.max(runningMax, 0) + nums[i];
            globalMax = Math.max(globalMax, runningMax);

            runningMin = Math.min(runningMin, 0) + nums[i];
            globalMin = Math.min(globalMin, runningMin);
            
            totalSum += nums[i];
        }
        if (totalSum == globalMin) {
            return globalMax;
        }
        return Math.max(totalSum - globalMin, globalMax);
    }
}