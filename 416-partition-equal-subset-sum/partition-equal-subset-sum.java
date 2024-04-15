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
        sum = sum / 2;
        dpTable = new Boolean[nums.length][sum + 1];
        return dp(nums, sum, nums.length - 1);
    }
    private boolean dp(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index < 0) {
            return false;
        }
        if (dpTable[index][target] != null) {
            return dpTable[index][target];
        }
        boolean useCurrent = dp(nums, target - nums[index], index - 1);
        boolean notUseCurrent = dp(nums, target, index - 1);
        dpTable[index][target] = useCurrent || notUseCurrent;
        return dpTable[index][target];
    }
}
