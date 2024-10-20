class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        
        while (left <= right) {
            int leftHeight = height[left];
            leftMax = Math.max(leftMax, leftHeight);
            int rightHeight = height[right];
            rightMax = Math.max(rightMax, rightHeight);

            if (leftHeight < rightHeight) {
                result += Math.min(leftMax, rightMax) - leftHeight;
                left++;
            } else {
                right--;
                result += Math.min(leftMax, rightMax) - rightHeight;
            }
        }
        return result;
    }
}