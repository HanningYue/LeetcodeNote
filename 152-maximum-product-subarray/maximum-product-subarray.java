class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] leftArray = new int[n];
        leftArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftArray[i] = leftArray[i - 1] == 0 ? nums[i] : leftArray[i - 1] * nums[i];
        }

        int[] rightArray = new int[n];
        rightArray[n - 1] = nums[n - 1];
        for (int i = n -  2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] == 0 ? nums[i] : rightArray[i + 1] * nums[i];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(leftArray[i], rightArray[i]));
        }
        return result;
    }
}