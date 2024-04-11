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
        return dp(nums, nums.length - 1, sum);
    }
    private boolean dp(int[] nums, int index, int target) {
        if (index < 0 || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dpTable[index][target] != null) {
            return dpTable[index][target];
        }
        boolean includeCurrent = dp(nums, index - 1, target - nums[index]);
        boolean excludeCurrent = dp(nums, index - 1, target);
        dpTable[index][target] = includeCurrent || excludeCurrent;
        return dpTable[index][target];

    }
}