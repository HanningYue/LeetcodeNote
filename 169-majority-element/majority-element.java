class Solution {
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide (int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftPart = divide(nums, left, mid);
        int rightPart = divide(nums, mid + 1, right);

        int leftMaxCount = conquer(nums, left, right, leftPart);
        int rightMaxCount = conquer(nums, left, right, rightPart);
        return leftMaxCount > rightMaxCount ? leftPart : rightPart;
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