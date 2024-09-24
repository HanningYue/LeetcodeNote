class Solution {
    Integer[] dpTableOne;
    Integer[] dpTableTwo;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        dpTableOne = new Integer[n];
        dpTableTwo = new Integer[n];
        
        int robFirst = dp(nums, dpTableOne, 0, n - 2);
        int notRobFirst = dp(nums, dpTableTwo, 1, n - 1);
        return Math.max(robFirst, notRobFirst);
    }
    private int dp(int[] nums, Integer[] dpTable, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != null) {
            return dpTable[start];
        }
        
        int robCurrent = dp(nums, dpTable, start + 2, end) + nums[start];
        int notRobCurrent = dp(nums, dpTable, start + 1, end);
        dpTable[start] = Math.max(robCurrent, notRobCurrent);
        return dpTable[start];
    }
}