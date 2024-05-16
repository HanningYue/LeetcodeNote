class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = left + rand.nextInt(right - left);
        pivotIndex = partition(nums, left, right, pivotIndex);
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int leftP = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, leftP, i);
                leftP++;
            }
        }
        swap(nums, leftP, right);
        return leftP;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}