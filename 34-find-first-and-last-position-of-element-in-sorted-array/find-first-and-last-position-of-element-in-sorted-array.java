class Solution {
    int leftBound, rightBound;
    public int[] searchRange(int[] nums, int target) {
        findLeft(nums, target);
        findRight(nums, target);
        return new int[]{leftBound, rightBound};        
    }
    private void findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left <= nums.length - 1 && nums[left] == target) {
            leftBound = left;
        } else {
            leftBound = -1;
        }
    }
    private void findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            rightBound = right;
        } else {
            rightBound = -1;
        }
    }
}