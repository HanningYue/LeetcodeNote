/*
Since the original array nums is guranteed to be in ascending order
    In the range of rotating 0 to n, rotate either 0, 1, 2, 3,.. times, the rotated array will always have a number at the start of array that is smaller than the number at the end of array UNLESS rotated by n times Which original array stays the same
    Thus, run a binary search to find 左边界
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}