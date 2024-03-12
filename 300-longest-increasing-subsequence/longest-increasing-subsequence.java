class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dpTable = new int[nums.length];
        Arrays.fill(dpTable, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpTable[i] = Math.max(dpTable[i], 1 + dpTable[j]);
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dpTable.length; i++) {
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}