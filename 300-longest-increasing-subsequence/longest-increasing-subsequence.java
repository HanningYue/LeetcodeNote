class Solution {
    Integer[] dpTable;
    public int lengthOfLIS(int[] nums) {
        dpTable = new Integer[nums.length];
        Arrays.fill(dpTable, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
        }
        int result = 0;
        for (int num : dpTable) {
            result = Math.max(result, num);
        }
        return result;
    }
}