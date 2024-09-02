class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = k - 1;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivotIndex = quickSelect(nums, left, right);
            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
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
            if (nums[leftP] < nums[pivotIndex] && nums[rightP] > nums[pivotIndex]) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            } 
            if (nums[leftP] >= nums[pivotIndex]) {
                leftP++;
            } 
            if (nums[rightP] <= nums[pivotIndex]) {
                rightP--;
            }
        }
        swap(nums, left, rightP);
        return rightP;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}