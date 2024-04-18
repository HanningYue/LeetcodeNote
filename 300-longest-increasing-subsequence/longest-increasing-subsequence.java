class Solution {
    Integer[] dpTable;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dpTable = new Integer[n];
        Arrays.fill(dpTable, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}