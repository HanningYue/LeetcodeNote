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
        return dp(nums, nums.length - 1, sum / 2);
    }
    private boolean dp(int[] nums, int index, int runningSum) {
        if (runningSum == 0) {
            return true;
        }
        if (index < 0 || runningSum < 0) {
            return false;
        }
        if (dpTable[index][runningSum] != null) {
            return dpTable[index][runningSum];
        }
 
        boolean useCurrent = dp(nums, index - 1, runningSum - nums[index]);
        boolean notUseCurrent = dp(nums, index - 1, runningSum);
        dpTable[index][runningSum] = useCurrent || notUseCurrent;
        return dpTable[index][runningSum];
    }
}