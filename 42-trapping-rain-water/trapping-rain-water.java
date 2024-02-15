class Solution {
    public int trap(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            result += Math.min(rightMax, leftMax) - height[i];
        }
        return result;
    }
}