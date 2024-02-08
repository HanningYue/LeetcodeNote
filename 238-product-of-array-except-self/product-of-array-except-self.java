class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = current;
            current *= nums[i];
        }

        current = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }
        return result;
    }
}