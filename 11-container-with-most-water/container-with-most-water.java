class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;

        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] >= height[right]) {
                right--;
            }
        }
        return result;
    }
}