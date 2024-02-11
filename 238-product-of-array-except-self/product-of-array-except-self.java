/**
[1, 2, 3, 4]. Use prefix product array
left to right : [1, 1, 2, 6]
right to left : [1 * 24, 1 * 12, 2 * 4, 6 because this is the final product from above]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        int currentProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = currentProduct;
            currentProduct *= nums[i];
        }

        currentProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = currentProduct * result[i];
            currentProduct *= nums[i];
        }
        return result;
    }
}