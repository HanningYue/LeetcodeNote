class Solution {
    Integer[] maxDpTable;
    Integer[] minDpTable;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        maxDpTable = new Integer[n];
        minDpTable = new Integer[n];
        maxDpTable[0] = minDpTable[0] = nums[0];
        
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            maxDpTable[i] = max(nums[i], nums[i] * maxDpTable[i - 1], nums[i] * minDpTable[i - 1]);
            minDpTable[i] = min(nums[i], nums[i] * maxDpTable[i - 1], nums[i] * minDpTable[i - 1]);
            result = Math.max(result, maxDpTable[i]);
        }
        return result;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
