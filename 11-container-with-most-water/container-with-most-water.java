class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        
        int result = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = (right - left) * Math.min(leftHeight, rightHeight);
            result = Math.max(result, area);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}