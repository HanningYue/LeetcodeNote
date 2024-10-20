class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftArray = new int[n];
        leftArray[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], height[i]);
        }

        int[] rightArray = new int[n];
        rightArray[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(leftArray[i], rightArray[i]) - height[i];
        }
        return result;
    }
}