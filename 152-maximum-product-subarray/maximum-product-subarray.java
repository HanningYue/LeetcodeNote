class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int leftRunningProduct = 1, rightRunningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (leftRunningProduct == 0) {
                leftRunningProduct = 1;
            }
            leftRunningProduct *= nums[i];
            
            if (rightRunningProduct == 0) {
                rightRunningProduct = 1;
            }
            rightRunningProduct *= nums[nums.length - 1 - i];

            result = Math.max(result, Math.max(leftRunningProduct, rightRunningProduct));
        }
        
        return result;
    }
}