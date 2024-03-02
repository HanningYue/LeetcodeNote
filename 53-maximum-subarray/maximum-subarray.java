/*
class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int runningSum = 0;
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

class Solution {
    public int maxSubArray(int[] nums) {
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int result = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, presum[i]);
            result = Math.max(result, presum[i + 1] - minVal);
        }
        return result;
    }
}
*/
//dp is the maxsum ending at the current nums[i]. Choose add current nums[i] or not
class Solution {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        int result = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, preSum[i]);
            result = Math.max(result, preSum[i + 1] - minVal);
        }
        return result;
    }
}