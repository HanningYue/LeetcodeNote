class Solution {
    Integer[] dpTable;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        dpTable = new Integer[n];
        dpTable[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpTable[i] = Math.max(nums[i], nums[i] + dpTable[i - 1]);
        }
        
        int max = Integer.MIN_VALUE;
        for (int num : dpTable) {
            max = Math.max(max, num);
        }
        return max;
    }
}