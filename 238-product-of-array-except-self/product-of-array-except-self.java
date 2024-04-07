class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int runningProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = runningProduct;
            
            runningProduct = runningProduct * nums[i];
        }

        runningProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * runningProduct;
            
            runningProduct = runningProduct * nums[i];
        }
        return result;
    }
}