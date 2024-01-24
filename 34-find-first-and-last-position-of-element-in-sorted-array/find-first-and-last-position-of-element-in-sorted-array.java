class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //Leftboundary
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int leftBoundary = left;

        //Rightboundary
        left = 0; 
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                left = mid + 1;
            } else if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || right >= nums.length || nums[right] != target) {
            return new int[]{-1, -1};
        }
        int rightBoundary = right;

        return new int[]{leftBoundary, rightBoundary};
    }
}