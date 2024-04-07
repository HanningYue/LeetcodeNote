class Solution {
    Integer[] dpTableOne;
    Integer[] dpTableTwo;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums[0];
        }
        dpTableOne = new Integer[nums.length];
        dpTableTwo = new Integer[nums.length];

        int doNotRobLast = dp(nums, 0, nums.length - 2, dpTableOne);
        int robLast = dp(nums, 1, nums.length - 1, dpTableTwo);
        int result = Math.max(doNotRobLast, robLast);
        return result;
    }
    private int dp(int[] nums, int start, int end, Integer[] dpTable) {
        if (start > end) {
            return 0;
        }
        if (dpTable[start] != null) {
            return dpTable[start];
        }
        int rob = dp(nums, start + 2, end, dpTable) + nums[start];
        int doNotRob = dp(nums, start + 1, end, dpTable);
        int result = Math.max(rob, doNotRob);
        dpTable[start] = result;
        return result;
    }
}