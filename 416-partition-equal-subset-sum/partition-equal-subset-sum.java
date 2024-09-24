class Solution {
    Boolean[][] dpTable;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dpTable = new Boolean[nums.length][sum / 2 + 1];
        return dp(nums, 0, 0, sum / 2);
    }
    private boolean dp(int[] nums, int runningSum, int index, int targetSum) {
        if (runningSum == targetSum) {
            return true;
        }
        if (index >= nums.length || runningSum > targetSum) {
            return false;
        }
        if (dpTable[index][runningSum] != null) {
            return dpTable[index][runningSum];
        }
        boolean useCurrent = dp(nums, runningSum + nums[index], index + 1, targetSum);
        boolean notUseCurrent = dp(nums, runningSum, index + 1, targetSum);
        dpTable[index][runningSum] = useCurrent || notUseCurrent;
        return dpTable[index][runningSum];
    }
}