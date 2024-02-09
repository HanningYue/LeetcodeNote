class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                if (leftMax > height[left]) {
                    result += leftMax - height[left];
                }
                left++;
            }
            else if (height[left] >= height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                if (rightMax > height[right]) {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}