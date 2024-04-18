class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            
            for (int left = i; left >= 0; left--) {
                leftMax = Math.max(leftMax, height[left]);
            }
            for (int right = i; right < height.length; right++) {
                rightMax = Math.max(rightMax, height[right]);
            }
            
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }
}