class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;

        while (left < right) {
            int water = 0;
            if (height[left] < height[right]) {
                water = (right - left) * height[left];
                left++;
            } else {
                water = (right - left) * height[right];
                right--;
            }
            result = Math.max(result, water);
        }
        return result;
    }
}