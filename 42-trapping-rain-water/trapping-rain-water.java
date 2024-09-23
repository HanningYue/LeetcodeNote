class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int result = 0;        
        int leftRunningMax = 0;
        int rightRunningMax = 0;
        for (int i = 0; i < n; i++) {
            leftRunningMax = Math.max(leftRunningMax, height[i]);
            leftMax[i] = leftRunningMax;
        }
        for (int j = n - 1; j >= 0; j--) {
            rightRunningMax = Math.max(rightRunningMax, height[j]);
            rightMax[j] = rightRunningMax;
        }

        for (int k = 0; k < n; k++) {
            int smaller = Math.min(leftMax[k], rightMax[k]);
            result += smaller - height[k];
        }
        return result;
    }
}