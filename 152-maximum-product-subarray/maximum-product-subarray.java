class Solution {
    Integer[] minTable;
    Integer[] maxTable;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        minTable = new Integer[n];
        maxTable = new Integer[n];
        minTable[0] = maxTable[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < n; i++) {
            minTable[i] = min(nums[i], minTable[i - 1] * nums[i], maxTable[i - 1] * nums[i]);
            maxTable[i] = max(nums[i], minTable[i - 1] * nums[i], maxTable[i - 1] * nums[i]);
            result = Math.max(result, maxTable[i]);
        }
        return result;
    }
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}