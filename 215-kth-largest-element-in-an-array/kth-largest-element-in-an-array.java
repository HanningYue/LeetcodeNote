class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        
        while (true) {
            int pivotIndex = findPivotIndex(nums, left, right);
            if (pivotIndex + 1 == k) {
                return nums[pivotIndex];
            } else if (pivotIndex + 1 < k) {
                left = pivotIndex + 1;
            } else if (pivotIndex + 1 > k) {
                right = pivotIndex - 1;
            }
        }
    }
    private int findPivotIndex(int[] nums, int left, int right) {
        int pivotNum = nums[left];

        int leftP = left + 1, rightP = right;
        while (leftP <= rightP) {
            if (nums[leftP] < pivotNum && nums[rightP] > pivotNum) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            }
            if (nums[leftP] >= pivotNum) {
                leftP++;
            }
            if (nums[rightP] <= pivotNum) {
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