class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProduct = new int[n];
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        int[] rightProduct = new int[n];
        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}