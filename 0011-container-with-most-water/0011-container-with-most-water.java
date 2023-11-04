/**
1. Want to find the container with most water == The largest satisfied area (Rectangle area)
2. Two pointer(index), given int[], right pointer index - left pointer index -> find length
3. Math.min(int[left], int[right]) -> find height
4. Update area each iteration, length * height
5. Move left pointer to right if left height is smaller and vice versa
*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = 0;
            area = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}