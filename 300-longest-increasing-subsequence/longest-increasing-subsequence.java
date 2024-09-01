class Solution {
    Integer[] currentLIS;
    public int lengthOfLIS(int[] nums) {
        currentLIS = new Integer[nums.length];
        Arrays.fill(currentLIS, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    currentLIS[i] = Math.max(currentLIS[i], currentLIS[j] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < currentLIS.length; i++) {
            result = Math.max(result, currentLIS[i]);
        }
        return result;
    }
}