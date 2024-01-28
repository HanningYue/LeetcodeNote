class Solution {
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int leftNumber = divide(nums, start, mid);
        int rightNumber = divide(nums, mid + 1, end);

        int leftMax = conquer(nums, leftNumber, start, mid);
        int rightMax = conquer(nums, rightNumber, mid + 1, end);
        return leftMax > rightMax ? leftNumber : rightNumber;
    }
    private int conquer(int[] nums, int target, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}