class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];

            result = Math.max(result, Math.max(leftProduct, rightProduct));
        }
        return result;
    }
}