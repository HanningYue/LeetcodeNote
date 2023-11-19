/*
Want to show the minimum size subarray sum, Use sliding window, slow and fast
Maintain a runningSum, while runningSum is GREATER than or Equal to target
    pop the slow, update window size at each iteration
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int runningSum = 0;
        int minSize = Integer.MAX_VALUE;
        
        for (int fast = 0; fast < nums.length; fast++) {
            runningSum += nums[fast];
            while (runningSum >= target) {
                minSize = Math.min(minSize, fast - slow + 1);
                runningSum -= nums[slow];
                slow++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}