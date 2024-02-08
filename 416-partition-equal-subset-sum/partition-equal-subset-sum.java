//dptable represents [i][j] , at ith place, if we can sum up (here is j) to sum / 2 ?
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        boolean[][] dpTable = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dpTable[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int currentWeight = nums[i - 1];
                if (j - currentWeight < 0) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = dpTable[i - 1][j] || dpTable[i - 1][j - currentWeight];
                }
            }
        }
        return dpTable[nums.length][sum];
    }
}