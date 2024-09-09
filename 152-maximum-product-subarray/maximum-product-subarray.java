class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int leftRunning = 1, rightRunning = 1;
        for (int i = 0; i < nums.length; i++) {
            leftRunning = leftRunning == 0 ? 1 : leftRunning;
            rightRunning = rightRunning == 0 ? 1 : rightRunning;
            leftRunning = leftRunning * nums[i];
            rightRunning = rightRunning * nums[nums.length - 1 - i];
            result = Math.max(result, Math.max(leftRunning, rightRunning));
        }
        return result;
    }
}