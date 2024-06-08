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

        int halfSum = sum / 2;
        dpTable = new Boolean[halfSum + 1][nums.length];
        return dp(nums, halfSum, nums.length - 1);
    }
    private boolean dp(int[] nums, int halfSum, int index) {
        if (halfSum == 0) {
            return true;
        }
        if (index < 0 || halfSum < 0) {
            return false;
        }
        if (dpTable[halfSum][index] != null) {
            return dpTable[halfSum][index];
        }

        boolean useCurrent = dp(nums, halfSum - nums[index], index - 1);
        boolean notUseCurrent = dp(nums, halfSum, index - 1);
        dpTable[halfSum][index] = useCurrent || notUseCurrent;
        return dpTable[halfSum][index];
    }
}