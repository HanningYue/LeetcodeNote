class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && nums[1] < nums[0]) {
                return 0;
            }
            if (mid == nums.length - 1 && nums[nums.length - 2] < nums[nums.length - 1]) {
                return nums.length - 1;
            }
            if (nums[mid + 1] < nums[mid] && nums[mid - 1] < nums[mid]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}