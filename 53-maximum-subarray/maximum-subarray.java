class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] dpTable = new int[nums.length];
        dpTable[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpTable[i] = Math.max(dpTable[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}