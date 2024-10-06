class Solution {
    public int maxProduct(int[] nums) {
        int leftRunning = 1;
        int rightRunning = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            leftRunning = leftRunning * nums[i];
            rightRunning = rightRunning * nums[nums.length - 1 - i];
            maxProduct = Math.max(Math.max(leftRunning, rightRunning), maxProduct);

            if (leftRunning == 0) {
                leftRunning = 1;
            }
            if (rightRunning == 0) {
                rightRunning = 1;
            }
        }
        return maxProduct;
    }
}