class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        Integer[] dpTable = new Integer[n];
        dpTable[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dpTable[i] = Math.max(dpTable[i - 1] + nums[i], nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}