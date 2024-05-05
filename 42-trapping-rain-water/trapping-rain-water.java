class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
            for (int left = 0; left <= i; left++) {
                leftMax = Math.max(leftMax, height[left]);
            }
            for (int right = n - 1; right >= i; right--) {
                rightMax = Math.max(rightMax, height[right]);
            }

            if (leftMax > rightMax) {
                result += rightMax - height[i];
            } else {
                result += leftMax - height[i];
            }
        }
        return result;
    }
}