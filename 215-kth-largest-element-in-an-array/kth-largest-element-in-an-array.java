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
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private int findPivotIndex(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        
        int pivot = nums[left];
        
        int leftP = left, rightP = right;
        while (leftP <= rightP) {
            if (nums[leftP] < pivot && nums[rightP] > pivot) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            }
            if (nums[leftP] >= pivot) {
                leftP++;
            }
            if (nums[rightP] <= pivot) {
                rightP--;
            }
        }
        swap(nums, left, rightP);
        return rightP;
    }
}