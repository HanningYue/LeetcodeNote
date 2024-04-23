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

        int robLast = dp(nums, 1, n - 1, dpTableOne);
        int notRobLast = dp(nums, 0, n - 2, dpTableTwo);
        return Math.max(robLast, notRobLast);
    }
    private int dp(int[] nums, int start, int end, Integer[] dpTable) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != null) {
            return dpTable[start];
        }
        int robCurrent = dp(nums, start + 2, end, dpTable) + nums[start];
        int notRobCurrent = dp(nums, start + 1, end, dpTable);
        dpTable[start] = Math.max(robCurrent, notRobCurrent);
        return dpTable[start];
    }
}