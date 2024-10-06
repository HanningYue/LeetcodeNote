class Solution {
    Integer[] dpMin;
    Integer[] dpMax;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        dpMin = new Integer[n];
        dpMin[0] = nums[0];
        dpMax = new Integer[n];
        dpMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dpMin[i] = min(nums[i], dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]);
            dpMax[i] = max(nums[i], dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]);
        }

        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            globalMax = Math.max(globalMax, dpMax[i]);
        }
        return globalMax;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}