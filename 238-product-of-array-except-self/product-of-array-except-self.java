class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int productOfLeft = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = productOfLeft;
            productOfLeft = productOfLeft * nums[i];
        }

        int productOfRight = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = productOfRight * result[i];
            productOfRight = productOfRight * nums[i];
        }

        return result;
    }
}