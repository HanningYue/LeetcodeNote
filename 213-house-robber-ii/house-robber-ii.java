class Solution {
    int[] dpTable1;
    int[] dpTable2;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        dpTable1 = new int[n];
        dpTable2 = new int[n];
        Arrays.fill(dpTable1, -1);
        Arrays.fill(dpTable2, -1);
        return Math.max(dp(nums, 0, n - 2, dpTable1), dp(nums, 1, n - 1, dpTable2));
    }
    private int dp(int[] nums, int start, int end, int[] dpTable) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != -1) {
            return dpTable[start];
        }
        int result = Math.max(dp(nums, start + 2, end, dpTable) + nums[start], 
                              dp(nums, start + 1, end, dpTable));
        dpTable[start] = result;
        return result;
    }
}