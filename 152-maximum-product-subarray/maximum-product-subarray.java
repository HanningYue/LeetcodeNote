class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int[] leftArray = new int[nums.length];
        leftArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftArray[i] = leftArray[i - 1] == 0 ? nums[i] : leftArray[i - 1] * nums[i];
        }

        int[] rightArray = new int[nums.length];
        rightArray[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] == 0 ? nums[i] : rightArray[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, Math.max(leftArray[i], rightArray[i]));
        }
        return result;
    }
}

/**
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
*/