class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (Math.abs(target) > sum) return 0; // Target out of possible sum range

        Integer[][] dpTable = new Integer[nums.length][2 * sum + 1];
        return dp(nums, 0, 0, target, dpTable, sum);
    }

    private int dp(int[] nums, int index, int currentSum, int target, Integer[][] dpTable, int sum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        
        if (dpTable[index][currentSum + sum] != null) {
            return dpTable[index][currentSum + sum];
        }
        
        int add = dp(nums, index + 1, currentSum + nums[index], target, dpTable, sum);
        int subtract = dp(nums, index + 1, currentSum - nums[index], target, dpTable, sum);
        
        dpTable[index][currentSum + sum] = add + subtract;
        return dpTable[index][currentSum + sum];
    }
}
