class Solution {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];

        leftMaxArr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }

        rightMaxArr[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMaxArr[j] = Math.max(height[j], rightMaxArr[j + 1]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int minOfTwoMax = Math.min(leftMaxArr[i], rightMaxArr[i]);
            result += minOfTwoMax - height[i];
        }
        return result;
    }
}