class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0 && nums[left] == target) {
            return left;
        } else if (left > 0 && nums[left - 1] == target) {
            return left - 1;
        } else {
            return -1;
        }
    }
}
