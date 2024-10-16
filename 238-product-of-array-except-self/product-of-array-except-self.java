class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        int leftRunningProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftRunningProduct;
            leftRunningProduct *= nums[i];
        }

        int rightRunningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightRunningProduct;
            rightRunningProduct *= nums[i];
        }
        return result;
    }
}