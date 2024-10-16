class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSub = divide(nums, left, mid);
        int rightSub = divide(nums, mid + 1, right);
        int leftFrequency = conquer(nums, left, right, leftSub);
        int rightFrequency = conquer(nums, left, right, rightSub);
        if (leftFrequency > rightFrequency) {
            return leftSub;
        }
        return rightSub;
    }
    private int conquer(int[] nums, int left, int right, int target) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}