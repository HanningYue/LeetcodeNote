class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        
        int slow = 0, fast = 0;        
        int runningSum = 0;
        while (fast < nums.length) {    
            int fastNum = nums[fast];
            runningSum += fastNum;
            
            while (runningSum >= target) {
                result = Math.min(result, fast - slow + 1);
                int slowNum = nums[slow];
                runningSum -= slowNum;
                slow++;
            }

            fast++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}