class Solution {
    public int majorityElement(int[] nums) {
        return compare(nums, 0, nums.length - 1);
    }
    private int compare(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftNum = compare(nums, left, mid);
        int rightNum = compare(nums, mid + 1, right);

        int leftFrequent = find(nums, left, right, leftNum);
        int rightFrequent = find(nums, left, right, rightNum);
        return leftFrequent > rightFrequent ? leftNum : rightNum;
    }
    private int find(int[] nums, int left, int right, int target) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}