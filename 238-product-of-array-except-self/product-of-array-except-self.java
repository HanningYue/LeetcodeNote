class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] leftRunning = new int[n];
        leftRunning[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftRunning[i] = nums[i - 1] * leftRunning[i - 1];
        }

        int[] rightRunning = new int[n];
        rightRunning[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightRunning[i] = nums[i + 1] * rightRunning[i + 1];
        }   

        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = leftRunning[i] * rightRunning[i]; 
        }
        return result;
    }
}