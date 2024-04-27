class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0] = nums[0];
        rightProducts[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            leftProducts[i] = (leftProducts[i - 1] == 0) ? nums[i] : leftProducts[i - 1] * nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = (rightProducts[i + 1] == 0) ? nums[i] : rightProducts[i + 1] * nums[i];
        }
        
        int result = nums[0];
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(leftProducts[i], rightProducts[i]));
        }

        return result;
    }
}
