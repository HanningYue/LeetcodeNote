class Solution {
    Integer[] dpTableOne;
    Integer[] dpTableTwo;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        dpTableOne = new Integer[nums.length];
        dpTableTwo = new Integer[nums.length];
        int result = Math.max(dp(nums, 0, nums.length - 2, dpTableOne), dp(nums, 1, nums.length - 1, dpTableTwo));
        return result;
    }
    private int dp(int[] nums, int startIdx, int endIdx, Integer[] dpTable) {
        if (startIdx > endIdx) {
            return 0;
        }
        if (dpTable[startIdx] != null) {
            return dpTable[startIdx];
        }
        int result = Math.max(dp(nums, startIdx + 1, endIdx, dpTable), 
                            dp(nums, startIdx + 2, endIdx, dpTable) + nums[startIdx]);
        dpTable[startIdx] = result;
        return result;
    }
}