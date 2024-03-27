class Solution {
    Integer[] dpTable1;
    Integer[] dpTable2;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        dpTable1 = new Integer[nums.length];
        dpTable2 = new Integer[nums.length];
        return Math.max(dp(nums, 0, nums.length - 2, dpTable1), dp(nums, 1, nums.length - 1, dpTable2));
    }
    private int dp(int[] nums, int start, int end, Integer[] dpTable) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != null) {
            return dpTable[start];
        }
        dpTable[start] = Math.max(dp(nums, start + 2, end, dpTable) + nums[start],
                                dp(nums, start + 1, end, dpTable));
        return dpTable[start];
    }
}