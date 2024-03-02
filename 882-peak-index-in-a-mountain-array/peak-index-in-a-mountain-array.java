class Solution {
    public int peakIndexInMountainArray(int[] nums) {   
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}