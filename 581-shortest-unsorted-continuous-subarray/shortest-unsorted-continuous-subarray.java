class Solution {
    public int findUnsortedSubarray(int[] nums) {
       int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int left = -1, right = -2;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                left = i;
            }
        }
        return right - left + 1;
    }
}