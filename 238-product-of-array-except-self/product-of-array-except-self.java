class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int leftProductExceptSelf = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProductExceptSelf;
            leftProductExceptSelf *= nums[i];
        }

        int rightProductExceptSelf = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightProductExceptSelf;
            rightProductExceptSelf *= nums[i];
        }

        return result;
    }
}