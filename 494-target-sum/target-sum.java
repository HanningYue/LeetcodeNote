class Solution {
    Integer[][] dpTable;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }

        dpTable = new Integer[nums.length][2 * sum + 1];
        return dp(nums, 0, 0, target, sum);
    }

    private int dp(int[] nums, int index, int runningSum, int target, int sum) {
        if (index == nums.length) {
            if (runningSum == target) {
                return 1;
            }
            return 0;
        }
        
        if (dpTable[index][runningSum + sum] != null) {
            return dpTable[index][runningSum + sum];
        }
        
        int add = dp(nums, index + 1, runningSum + nums[index], target, sum);
        int minus = dp(nums, index + 1, runningSum - nums[index], target, sum);
        
        dpTable[index][runningSum + sum] = add + minus;
        return dpTable[index][runningSum + sum];
    }
}