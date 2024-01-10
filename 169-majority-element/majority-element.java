class Solution {
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        int leftHalf = divide(nums, left, mid);
        int rightHalf = divide(nums, mid + 1, right);
        if (leftHalf == rightHalf) {
            return leftHalf;
        }
        int leftCount = conquer(nums, leftHalf, left, right);
        int rightCount = conquer(nums, rightHalf, left, right);
        return leftCount > rightCount ? leftHalf : rightHalf;
    }
    private int conquer(int[] nums, int element, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == element) {
                count++;
            }
        }
        return count;
    }
}