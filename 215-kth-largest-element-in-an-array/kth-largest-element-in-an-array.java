class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }
    private int partition(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }

        int pivotIndex = left;
        int leftP = left, rightP = right;
        while (leftP <= rightP) {
            while (leftP <= rightP && nums[leftP] <= nums[pivotIndex]) {
                leftP++;
            }
            while (leftP <= rightP && nums[rightP] >= nums[pivotIndex]) {
                rightP--;
            }
            if (leftP <= rightP) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            }
        }
        swap(nums, pivotIndex, rightP);
        return rightP;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}