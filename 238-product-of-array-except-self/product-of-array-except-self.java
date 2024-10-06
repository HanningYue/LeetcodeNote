class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftRunningProduct = 1;
        int rightRunningProduct = 1;
        int n = nums.length;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftRunningProduct;
            leftRunningProduct = leftRunningProduct * nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightRunningProduct;
            rightRunningProduct = rightRunningProduct * nums[i];
        }
        return result;
    }
}