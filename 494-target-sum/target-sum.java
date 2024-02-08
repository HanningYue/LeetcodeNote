class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        sum = (sum + target) / 2;

        int n = nums.length;
        int[][] dpTable = new int[n + 1][sum + 1];
        dpTable[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                int currentNum = nums[i - 1];
                if (j < currentNum) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i - 1][j - currentNum];
                }
            }
        }
        return dpTable[n][sum];
    }
}