class Solution {
    public int findKthPositive(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentMissing = nums[mid] - mid - 1;
            if (currentMissing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}