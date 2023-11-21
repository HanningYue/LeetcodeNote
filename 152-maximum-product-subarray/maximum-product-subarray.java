/**
1. We want to find the largest product subarray, we can traverse from left to right, right to left
2. If there is 0 in the array, we return 1 for both side
3. Update max at each iteration, remember to use *= */

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct = (leftProduct == 0 ? 1 : leftProduct);
            rightProduct = (rightProduct == 0 ? 1 : rightProduct);
            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
}