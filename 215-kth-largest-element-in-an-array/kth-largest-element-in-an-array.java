class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = quickSelect(nums, left, right);
            if (pivot == k) {
                return nums[pivot];
            } else if (pivot > k) {
                right = pivot - 1;
            } else if (pivot < k) {
                left = pivot + 1;
            }
        }       
    }
    private int quickSelect(int[] nums, int left, int right) {
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