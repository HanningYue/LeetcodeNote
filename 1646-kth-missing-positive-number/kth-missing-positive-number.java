class Solution {
    public int findKthPositive(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - (mid + 1) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + k;
    }
}