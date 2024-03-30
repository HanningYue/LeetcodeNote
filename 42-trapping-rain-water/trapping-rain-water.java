class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
            }
            else if (leftMax >= rightMax) {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}