class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        int runningSum = 0;
        while (fast < nums.length) {
            runningSum += nums[fast];
            while (runningSum >= target) {
                result = Math.min(result, fast - slow + 1);
                runningSum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}