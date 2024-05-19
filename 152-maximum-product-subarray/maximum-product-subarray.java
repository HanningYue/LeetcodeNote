class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int leftRunningProduct = 1;
        int rightRunningProduct = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (leftRunningProduct == 0) {
                leftRunningProduct = 1;
            }
            leftRunningProduct = leftRunningProduct * nums[i];

            if (rightRunningProduct == 0) {
                rightRunningProduct = 1;
            }
            rightRunningProduct = rightRunningProduct * nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(leftRunningProduct, rightRunningProduct));
        }
        return maxProduct;
    }
}