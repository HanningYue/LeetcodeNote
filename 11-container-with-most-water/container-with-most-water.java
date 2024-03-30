class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            result = Math.max(result, currentArea);

            if (height[left] < height[right]) {
                left++;
            }
            else if (height[left] >= height[right]) {
                right--;
            }
        }
        return result;
    }
}