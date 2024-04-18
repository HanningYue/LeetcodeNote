class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int runningProduct = 1;

            for (int j = i; j < n; j++) {
                runningProduct *= nums[j];
                result = Math.max(result, runningProduct);
            }
        }
        return result;
    }
}