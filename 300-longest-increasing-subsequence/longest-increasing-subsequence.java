class Solution {
    private Integer[] dpTable;
    public int lengthOfLIS(int[] nums) {
        dpTable = new Integer[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, find(nums, i, dpTable));
        }
        return maxLength;
    }
    private int find(int[] nums, int index, Integer[] dpTable) {
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        int maxLength = 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                maxLength = Math.max(maxLength, 1 + find(nums, i, dpTable));
            }
        }
        dpTable[index] = maxLength;
        return maxLength;
    }
}