class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return new int[]{-1, -1};
        }
        int leftBoundary = (target == nums[left] ? left : -1);

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || right >= nums.length) {
            return new int[]{-1, -1};
        }
        int rightBoundary = (target == nums[right] ? right : -1);

        return new int[]{leftBoundary, rightBoundary};
    }
}