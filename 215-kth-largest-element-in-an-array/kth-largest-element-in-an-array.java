class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = findPivotIndex(nums, left, right);
            if (pivot + 1 == k) {
                return nums[pivot];
            } else if (pivot + 1 > k) {
                right = pivot - 1;
            } else if (pivot + 1 < k) {
                left = pivot + 1;
            }
        }
    }
    private int findPivotIndex(int[] nums, int left, int right) {
        int pivotValue = nums[left];
        int leftP = left + 1, rightP = right;

        while (leftP <= rightP) {
            // Move leftP right until finding an element smaller than pivotValue
            while (leftP <= rightP && nums[leftP] >= pivotValue) {
                leftP++;
            }
            // Move rightP left until finding an element greater than pivotValue
            while (leftP <= rightP && nums[rightP] < pivotValue) {
                rightP--;
            }
            // Swap elements to move larger elements to the left and smaller to the right
            if (leftP < rightP) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            }
        }
        // Swap pivot into correct place
        swap(nums, left, rightP);
        return rightP;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}