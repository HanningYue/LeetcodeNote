class Solution {
    Integer[] dpTableOne;
    Integer[] dpTableTwo;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int m = nums.length;
        dpTableOne = new Integer[m];
        dpTableTwo = new Integer[m];
        int notRobLast = dp(nums, 0, nums.length - 2, dpTableOne);
        int robLast = dp(nums, 1, nums.length -1, dpTableTwo);
        return Math.max(robLast, notRobLast);
    }

    private int dp(int[] nums, int start, int end, Integer[] dpTable) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != null) {
            return dpTable[start];
        }
        int notRobCurrent = dp(nums, start + 1, end, dpTable);
        int robCurrent = dp(nums, start + 2, end, dpTable) + nums[start];
        dpTable[start] = Math.max(notRobCurrent, robCurrent);
        return dpTable[start];
    }
}