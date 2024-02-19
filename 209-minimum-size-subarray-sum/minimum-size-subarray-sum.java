class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0;
        int runningSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (fast < nums.length) {
            runningSum += nums[fast];    
            while (runningSum >= target) {
                minLength = Math.min(minLength, fast - slow + 1);
                runningSum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}