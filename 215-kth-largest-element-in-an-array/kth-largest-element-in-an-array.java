class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private int quickSelect(int[] nums, int left, int right, int targetK) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == targetK) {
            return nums[pivotIndex];
        } else if (pivotIndex > targetK) {
            return quickSelect(nums, left, pivotIndex - 1, targetK);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, targetK);
        }
    }
    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left);
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int leftP = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
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