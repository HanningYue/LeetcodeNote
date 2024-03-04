class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBoundary = findLeftBound(nums, target);
        if (leftBoundary == -1) {
            return new int[]{-1, -1};
        }

        int rightBoundary = findRightBound(nums, target);
        if (rightBoundary == -1) {
            return new int[]{-1, -1};
        }
        
        return new int[]{leftBoundary, rightBoundary};
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
