class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid;
            }
        }

        if (nums[left] > nums[right]) {
            return left;
        } else {
            return right;
        }
    }
}