class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        Integer[] dpTable = new Integer[n];
        dpTable[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpTable[i] = Math.max(nums[i], nums[i] + dpTable[i - 1]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}
/**
class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int result = Integer.MIN_VALUE;
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
*/