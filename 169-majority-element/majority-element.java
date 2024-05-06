class Solution {
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int left, int right) {
        if (left > right) {
            return nums[0];
        }

        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftNum = divide(nums, left, mid);
        int rightNum = divide(nums, mid + 1, right);
        
        int leftMajority = find(nums, leftNum, left, right);
        int rightMajority = find(nums, rightNum, left, right);
        return leftMajority > rightMajority ? leftNum : rightNum;
    }
    private int find(int[] nums, int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}